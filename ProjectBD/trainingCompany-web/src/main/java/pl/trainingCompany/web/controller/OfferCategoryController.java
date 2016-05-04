package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.service.OfferCategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016-03-26.
 */
@RestController
@RequestMapping("/offerCategory")
public class OfferCategoryController extends AbstractController<OfferCategory,DtoOfferCategory,OfferCategoryService>{

    @RequestMapping("/init")
    public void init(){
        List<String> categoryNameList = new ArrayList<String>();
        categoryNameList.add("Umiejętności osobiste");
        categoryNameList.add("Zarządzanie zespołem");
        categoryNameList.add("Sprzedaż i marketing");
        categoryNameList.add("Finanse i rachunkowość");
        categoryNameList.add("Zarządzanie organizacją");
        categoryNameList.add("Zarządzanie jakością");
        categoryNameList.add("Szkolenia zawodowe");
        categoryNameList.add("Kursy");
        categoryNameList.add("Unia Europejska");
        categoryNameList.add("Administracja IT");
        categoryNameList.add("Obsługa oprogramowania");
        categoryNameList.add("Informatyka certyfikaty");
        categoryNameList.add("Projektowanie");
        categoryNameList.add("Programowanie");
        categoryNameList.add("Prawo i zamówienia publiczne");
        categoryNameList.add("Ochrona środowiska");
        categoryNameList.add("Laboratoria");
        categoryNameList.add("Internet");
        categoryNameList.add("Logistyka");
        categoryNameList.add("Produkcja");
        categoryNameList.add("Szkolenia zawodowe");
        categoryNameList.add("Szkolenia HR");
        categoryNameList.add("Placówki ochrony zdrowia");
        categoryNameList.add("Administracja");
        categoryNameList.add("Studia podyplomowe");
        categoryNameList.add("Ubezpieczenia");
        categoryNameList.add("Konferencje");
        categoryNameList.add("ABI");
        categoryNameList.add("Telekomunikacja");
        categoryNameList.add("Kursy kosztorysowania");
        categoryNameList.add("Projektowanie komputerowe");
        categoryNameList.add("Inne");

        for (String offerCategoryName: categoryNameList){
            service.save(offerCategoryName,offerCategoryName);
        }

    }

}
