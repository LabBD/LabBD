package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.trainingCompany.model.GetOfferPageRequestBody;
import pl.trainingCompany.model.ValueWrapper;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.repo.OfferCategoryRepo;
import pl.trainingCompany.service.CompanyService;
import pl.trainingCompany.service.GuestService;
import pl.trainingCompany.service.OfferCategoryService;
import pl.trainingCompany.service.OfferService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Kamil S on 2016-03-24.
 */
@RestController
@RequestMapping("/offer")
public class OfferController extends AbstractController<Offer, DtoOffer, OfferService> {

    @Autowired
    GuestService guestService;

    @Autowired
    OfferCategoryRepo offerCategoryRepo;

    @Autowired
    OfferCategoryService offerCategoryService;

    @Autowired
    AttachmentController attachmentController;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/init")
    public void init() {
        List<String> offerName = new ArrayList();
        List<String> offerDescription = new ArrayList();
        Random random = new Random();

        offerName.add("KSZTAŁTOWANIE ASERTYWNEJ SYLWETKI LIDERA Z ELEMENTAMI RADZENIA SOBIE ZE STRESEM");
        offerDescription.add("Budowanie pozycji lidera jest bardzo ważnym i dalekowzrocznym działaniem mającym na celu stworzenie organizacji nastawionej na rozwój i dążącej do ciągłego doskonalenia się. Skoro to jest takie oczywiste to dla czego takie trudne? Bycie liderem to nie tylko umiejętność komunikacji czy bycia asertywnym. To również budowanie narzędzi, które pomogą podległemu personelowi realizować się w firmie i przestrzegać wartości, które wynikają z ich przekonań a nie przymusu.\n" +
                "\n" +
                "Asertywność to umiejętność wyrażania własnych uczuć, opinii, pragnień w różnych sytuacjach zawodowych w sposób otwarty i pozbawiony lęku, a zarazem respektujący uczucia i postawy innych.\n" +
                "Asertywny lider to taki który jasno stawia granice a nie uważa, że pracownicy się ich domyślą, wspiera a nie wyręcza, nagradza a nie schlebia, egzekwuje a nie krzyczy, udziela jasnych informacji, a nie krytykuje, a także wyciąga konsekwencje i umie odmawiać");

        offerName.add("TECHNIKI OBRONY CENY");
        offerDescription.add("Zapraszamy Państwa na szkolenie podczas którego, uczestnicy przygotują się do profesjonalnego i skutecznego prowadzania rozmów dotyczących ceny oraz negocjacji cenowych ze swoimi partnerami biznesowymi. Uczestnicy będą mogli przećwiczyć praktycznie techniki dotyczące obrony ceny przy wykorzystaniu dobranych argumentów.");

        offerName.add("Szkolenie - Komunikacja nastawiona na budowanie współpracy");
        offerDescription.add("Podstawowym celem warsztatu jest zatem dostarczenie uczestnikom wiedzy i umiejętności z zakresu skutecznego komunikowania się w sytuacjach zawodowych, w których sprawna komunikacja jest narzędziem tworzenia i podtrzymywania relacji społecznych oraz współpracy między ludźmi. Sprawna komunikacja i współpraca wewnątrz firmy ma bezpośrednie przełożenie na relacje i współpracę z innymi podmiotami. Znaczną część warsztatu zajmować będą aktywności tworzące pozytywny klimat sprzyjający komunikacji nastawionej na współpracę. ");

        offerName.add("Szkolenie - Asertywność w pracy. Czy można się tego nauczyć ?");
        offerDescription.add("Warsztaty skierowane są do wszystkich osób zainteresowanych tematyką Asertywności, które pragną poszerzyć swoją wiedze w tym temacie.");

        offerName.add("Szkolenie - Autoprezentacja czyli jak dobrze wypaść przed każdą publicznością");
        offerDescription.add("Zasady wystąpień publicznych\n" +
                "- Tworzenie scenariusza dobrej prezentacji/wystąpienia (struktura, spójność wypowiedzi, myśl przewodnia, kompozycja ramowa, oryginalność)\n" +
                "- Budowanie kontaktu z audytorium (nawiązywanie dobrego kontaktu z odbiorcami, panowanie nad audytorium, radzenie sobie z trudnymi słuchaczami)\n" +
                "- Praktyczne sposoby walki z tremą\n" +
                "- Elementy fonetyki, dykcja, emisja głosu\n" +
                "\n" +
                "Budowanie wizerunku\n" +
                "- Znaczenie efektu pierwszego wrażenia (umiejętność skupienia uwagi, nieszablonowość, dostosowanie do audytorium, dobór argumentacji)\n" +
                "- Podstawy komunikacji werbalnej i niewerbalnej\n" +
                "- Kreowanie wizerunku statycznego – wygląd zewnętrzny\n" +
                "- Kreowanie wizerunku dynamicznego – sposób poruszania się, mimika, gestykulacja, ekspresja wypowiedzi");
//////////////////////////////
        offerName.add("NOWOCZESNE STRATEGIE ZARZĄDZANIA ZESPOŁEM intensywne warsztaty dla kadry kierowniczej");
        offerDescription.add("Warsztaty szkoleniowe rozwijające kreatywne myślenie w zarządzaniu zespołem, oparte na poszukiwaniu niestandardowych rozwiązań wpływających na zwiększenie efektywności swoich współpracowników. Uczestnicy szkolenia zdobędą wiedzę i podniosą swoje kompetencje, które pozwolą m.in. sprawnie delegować zadania, motywować pracowników radzić sobie w sytuacjach konfliktowych oraz budować pozytywne relacje w zespole.");

        offerName.add("BUDOWANIE EFEKTYWNEGO ZESPOŁU");
        offerDescription.add("Zmotywowany, efektywny, zaangażowany zespół jest filarem prężnie działającej firmy i podstawą skutecznego realizowania wyznaczonych zadań. Stworzenie mocnego zespołu wymaga działań nastawionych na budowanie zespołowego poczucia celu i wartości, kreowania atmosfery efektywnej współpracy i efektywnej komunikacji, która gwarantuje sukces.");

        offerName.add("Doskonalenie kompetencji lidera produkcji");
        offerDescription.add("Celem szkolenia jest rozwój kompetencji menadżerskich u szefów średniego i niższego szczebla, które pomogą im poradzić sobie w trudnych sytuacjach z jakimi może on się spotkać na produkcji. Przeanalizujemy jak należy prowadzić zespół i jak go zmieniać, żeby był przygotowany do podejmowania nowych wyzwań przy ograniczeniu sytuacji konfliktowych. Zastanowimy się jak przy wzrastającej ilości zadań nakładanych na menadżerów wygospodarować czas na rozmowę z pracownikiem oraz umiejętnie obciążyć zespół zadaniami, które będą go rozwijać i motywować. Przećwiczymy narzędzia, które powodują wzrost motywacji indywidualnej i zespołowej. Prześledzimy na zapisach video jakie błędy popełniamy podczas trudnych rozmów z pracownikami.");

        offerName.add("Doskonalenie umiejętności menadżerskich");
        offerDescription.add("Cel szkolenia:\n" +
                "Nakreślenie mapy podstawowych cech i umiejętności skutecznego menedżera\n" +
                "Dostarczenie wiedzy o podstawowych obszarach działań lidera\n" +
                "Przećwiczenie umiejętności kierowania działaniami innych i wpływania na jakość pracy oraz decyzje i zaangażowanie współpracowników\n" +
                "Umożliwienie autodiagnozy własnych predyspozycji menedżerskich");

        offerName.add("rozwój kompetencji menadżerskich ,poziom zaawansowany");
        offerDescription.add("Program kładzie nacisk na elementy, które nie pojawiają się w Państwa programie szkolenia podstawowego takie jak:\n" +
                "zaawansowane ćwiczenia konkretnych przypadków zgłoszonych przez uczestników;\n" +
                "zarządzanie sytuacyjne – model Hersey’a / Blanchard’a;\n" +
                "pokolenie Y ;\n" +
                "konflikt w zespole;\n" +
                "coaching, jako narzędzie menedżera;\n" +
                "elementy języka perswazji;\n" +
                "przyjmowanie feedbacku, jako podstawowa umiejętność w ciągłym rozwoju menedżera;\n" +
                "motywację jako ważne narzędzie menadżera.");
/////////////////////////////
        offerName.add("");
        offerDescription.add("");

        offerName.add("");
        offerDescription.add("");

        offerName.add("");
        offerDescription.add("");

        offerName.add("");
        offerDescription.add("");

        offerName.add("");
        offerDescription.add("");
//////////////////////////////
        offerName.add("");
        offerDescription.add("");

//        for (int j = 0; j < 1000; j++) {
//            if(j%20==0)
//                System.out.println(j);
            for (int i = 0; i < offerName.size(); i++) {
                //service.save(offerName.get(i), offerDescription.get(i), new Double(random.nextInt(2000)), new Long(random.nextInt(100)), new Date(),(int) i / 5);
            }
//        }


    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNew")
    public ModelAndView saveNewOffer(@RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("price") Double price,
                                     @RequestParam("quantity") Long quantity,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("category") String categoryName,
                                     @RequestParam("name") String attchName,
                                     @RequestParam("attachmentType") String attchType,
                                     @RequestParam("file") MultipartFile file,
                                     RedirectAttributes redirectAttributes) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dateFormat.parse(endDate);
        final OfferCategory category = offerCategoryRepo.findByname(categoryName);
        if(category!=null) {
            Long offerId = service.save(title,description,price,quantity,date,category);
            if(offerId != null) {
                redirectAttributes.addFlashAttribute("message", "Offer added properly.");
                boolean isAtchAdded = attachmentController.handleFileUpload(attchName,attchType,offerId,file,redirectAttributes);
                return isAtchAdded ? new ModelAndView("redirect:http://localhost:8080/user/#/addOffer") : new ModelAndView("redirect:http://localhost:8080/#/error/attachmentError");
            } else {
                return new ModelAndView("redirect:http://localhost:8080/#/error/addOfferError");
            }
        }
        return new ModelAndView("redirect:http://localhost:8080/#/error/addOfferError");
    }

    @Override
    public DtoOffer findOne(@PathVariable int id, HttpServletRequest request) {
        Offer offer = service.findOfferDbo(new Long(id));
        if (offer == null)
            return null;
        guestService.checkExistsAndSave(new Long(id), request.getSession().getId(), offer);
        return service.getMapper().convertToDTO(offer);
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.POST)
    public Iterable<DtoOffer> getOfferPage(@RequestBody GetOfferPageRequestBody requestBody, @PathVariable int pageNumber) {
        return service.getOfferPage(requestBody.getQuery(), pageNumber - 1, requestBody.getSelectedOfferCategory(),null);
    }

    @RequestMapping(value = "/my/page/{pageNumber}", method = RequestMethod.POST)
    public Iterable<DtoOffer> getMyOfferPage(@RequestBody GetOfferPageRequestBody requestBody, @PathVariable int pageNumber) {

        Company loggedCompany = companyService.getLoggedCompany();
        if(loggedCompany==null)
            return null;
        return service.getOfferPage(requestBody.getQuery(), pageNumber - 1, requestBody.getSelectedOfferCategory(),loggedCompany);
    }

    @RequestMapping(value = "/page/count", method = RequestMethod.POST)
    public LongWraper getOfferPageCount(@RequestBody GetOfferPageRequestBody requestBody) {
        LongWraper longWraper = new LongWraper();
        longWraper.value = service.getOfferPageCount(requestBody.getQuery(), requestBody.getSelectedOfferCategory(),null);
        return longWraper;
    }

    @RequestMapping(value = "/page/my/count", method = RequestMethod.POST)
    public LongWraper getMyOfferPageCount(@RequestBody GetOfferPageRequestBody requestBody) {
        LongWraper longWraper = new LongWraper();
        Company loggedCompany = companyService.getLoggedCompany();
        longWraper.value = service.getOfferPageCount(requestBody.getQuery(), requestBody.getSelectedOfferCategory(),loggedCompany);
        return longWraper;
    }

    class LongWraper {
        public Long value;
    }

}
