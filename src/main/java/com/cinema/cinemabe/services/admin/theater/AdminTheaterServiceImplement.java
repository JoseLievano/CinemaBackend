package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.admin.theater.TheaterMapper;
import com.cinema.cinemabe.mapper.admin.theater.ZoneMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneMiniDTO;
import com.cinema.cinemabe.models.entity.theater.GridStructure;
import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.entity.theater.TheaterType;
import com.cinema.cinemabe.models.entity.theater.Zone;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterForm;
import com.cinema.cinemabe.models.form.admin.theater.AdminZoneForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterUpdateForm;
import com.cinema.cinemabe.repository.GridStructureRepository;
import com.cinema.cinemabe.repository.TheaterRepository;
import com.cinema.cinemabe.repository.TheaterTypeRepository;
import com.cinema.cinemabe.repository.ZoneRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class AdminTheaterServiceImplement extends DefaultServiceImplement <AdminTheaterDTO, AdminTheaterMiniDTO, AdminTheaterForm, AdminTheaterUpdateForm, Theater, Integer> {

    @Autowired
    private TheaterTypeRepository theaterTypeRepository;

    @Autowired
    private GridStructureRepository gridStructureRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private ZoneMapper zoneMapper;

    protected AdminTheaterServiceImplement(TheaterRepository repository, TheaterMapper mapper){
        super(repository,mapper);
    }

    @Override
    public AdminTheaterMiniDTO insert(AdminTheaterForm form) throws ElementNotFoundExeption {

        Theater toInsert = mapper.toEntity(form);

        if (form.getTheaterType() != null){
            toInsert.setTheaterType(theaterTypeRepository.getById(form.getTheaterType()));
        }

        GridStructure grid;

        if (form.getGridStructure() != null){
            grid = gridStructureRepository.findById(form.getGridStructure()).orElseThrow(ElementNotFoundExeption::new);
            toInsert.setGridStructure(grid);
        }

        repository.save(toInsert);

        generateSeats(toInsert.getGridStructure().getBluePrint(), toInsert.getGridStructure().getColumns(), toInsert.getGridStructure().getRows(), toInsert);

        return mapper.toSmallDTO(toInsert);

    }

    @Override
    public AdminTheaterDTO update(Integer id, AdminTheaterUpdateForm uform) throws ElementNotFoundExeption {

        Theater toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        if (uform.getName() != null){
            toUpdate.setName(uform.getName());
        }

        if (uform.getTheaterType() != null){
            TheaterType theaterType = theaterTypeRepository.getById(uform.getTheaterType());
            toUpdate.setTheaterType(theaterType);
        }


        //Process to do if we update the gridstructure
        //This variable is going to help us to verify if the grid has been updated
        boolean gridUpdated = false;

        if (uform.getGridStructure() != null){
            gridUpdated = true;
            GridStructure gridStructure = gridStructureRepository.getById(uform.getGridStructure());
            toUpdate.setGridStructure(gridStructure);

        }

        repository.save(toUpdate);

        //Regenerate seats only if grid was updated
        if (gridUpdated){

            //Remove all seats because we need to generate new ones
            flushSeats(toUpdate.getId());

            System.out.println("Seats list is: " + toUpdate.getZones().size() );

            //We pass the new information to the generateSeats() functions to create the new seats, because we already remove the old ones.
            generateSeats(toUpdate.getGridStructure().getBluePrint(), toUpdate.getGridStructure().getColumns(), toUpdate.getGridStructure().getRows(), toUpdate);
        }

        return mapper.toDTO(toUpdate);

    }

    public boolean flushSeats(Integer id) throws ElementNotFoundExeption {

        Theater theater = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        List<Zone> zones = theater.getZones();

        while (theater.getZones().size() > 0){

            Zone actualZone = zones.get(0);

            Integer idactual = actualZone.getId();

            System.out.println("Borrando: " + actualZone.getId());

            zoneRepository.delete(actualZone);

            if (zoneRepository.existsById(idactual)){
                System.out.println("aun existe :S" + idactual);
            }else {
                System.out.println("Ya no existe :P" + idactual);
            }
        }

        if (theater.getZones().size() == 0){
            return true;
        }else {
            return false;
        }

    }

    private void generateSeats(String blueprint, Integer col, Integer row, Theater theater){

        /*
        Blue Print example
        0011110011
        0011110011
        0011110011
        In string format will looks like: 001111001100111100110011110011
        We use this to generate all the seats and names for each seat
        All avalible seats are represented by 1, and blank space is 0
        */

        String[] abc = {"A", "B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","Ak","AL","AM","AN"};
        System.out.println(abc.length);
        AdminZoneMiniDTO[][] zone =new AdminZoneMiniDTO[row][col];

        int counterBluePrint = 0;
        int nameCounter = 1;

        for (int i = 0; i < zone.length; i++){

            String colLetter = abc[i];
            Integer seatNumber = 1;

            for (int z = 0; z < zone[i].length; z++){

                char actualState = blueprint.charAt(counterBluePrint);

                Boolean isSeat = false;

                String name = " ";

                if (actualState == '1'){
                    isSeat= true;
                    name = colLetter + seatNumber;
                    nameCounter++;
                    seatNumber++;
                }

                System.out.println(name);

                AdminZoneForm newForm = AdminZoneForm.builder()
                        .name(name)
                        .isASeat(isSeat)
                        .build();

                Zone toInsert = zoneMapper.toEntity(newForm);

                toInsert.setTheater(theater);

                zoneRepository.save(toInsert);

                counterBluePrint++;

            }

        }


    }
}
