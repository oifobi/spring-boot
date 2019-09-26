package guru.springframework.controllers;

import guru.springframework.commands.*;
import guru.springframework.converters.*;
import guru.springframework.domain.*;
import guru.springframework.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {

    private ProductService productService;
    private ProductToProductForm productToProductForm;

    private PackagingService packagingService;
    private PackagingToPackagingForm packagingToPackagingForm;


    private FactoryService factoryService;
    private FactoryToFactoryForm factoryToFactoryForm;

    private ManService manService;
    private ManToManForm manToManForm;

    private BeerTypeService beerTypeService;
    private BeerTypeToBeerTypeForm beerTypeToBeerTypeForm;


    private BeerTypeHistoryService beerTypeHistoryService;
    private BeerTypeHistoryToBeerTypeHistoryForm beerTypeHistoryToBeerTypeHistoryForm;


    private BeerService beerService;
    private BeerToBeerForm beerToBeerForm;


    private BeerTypeDescrService beerTypeDescrService;
    private BeerTypeDescrToBeerTypeDescrForm beerTypeDescrToBeerTypeDescrForm;


    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @Autowired
    public void setPackagingToPackagingForm(PackagingToPackagingForm packagingToPackagingForm) {
        this.packagingToPackagingForm = packagingToPackagingForm;
    }

    @Autowired
    public void setPackagingService(PackagingService packagingService) {
        this.packagingService = packagingService;
    }


    @Autowired
    public void setFactoryToFactoryForm(FactoryToFactoryForm factoryToFactoryForm) {
        this.factoryToFactoryForm = factoryToFactoryForm;
    }

    @Autowired
    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Autowired
    public void setManService(ManService manService) {
        this.manService = manService;
    }

    @Autowired
    public void setManToManForm(ManToManForm manToManForm) {
        this.manToManForm = manToManForm;
    }

    @Autowired
    public void setBeerTypeService(BeerTypeService beerTypeService) {
        this.beerTypeService = beerTypeService;
    }

    @Autowired
    public void setBeerTypeToBeerTypeForm(BeerTypeToBeerTypeForm beerTypeToBeerTypeForm) {
        this.beerTypeToBeerTypeForm = beerTypeToBeerTypeForm;
    }

    @Autowired
    public void setBeerTypeHistoryService(BeerTypeHistoryService beerTypeHistoryService) {
        this.beerTypeHistoryService = beerTypeHistoryService;
    }

    @Autowired
    public void setBeerTypeHistoryToBeerTypeHistoryForm(BeerTypeHistoryToBeerTypeHistoryForm beerTypeHistoryToBeerTypeHistoryForm) {
        this.beerTypeHistoryToBeerTypeHistoryForm = beerTypeHistoryToBeerTypeHistoryForm;
    }

    @Autowired
    public void setBeerTypeDescrService(BeerTypeDescrService beerTypeDescrService) {
        this.beerTypeDescrService = beerTypeDescrService;
    }

    @Autowired
    public void setBeerTypeDescrToBeerTypeDescrForm(BeerTypeDescrToBeerTypeDescrForm beerTypeDescrToBeerTypeDescrForm) {
        this.beerTypeDescrToBeerTypeDescrForm = beerTypeDescrToBeerTypeDescrForm;
    }


    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    public void setBeerToBeerForm(BeerToBeerForm beerToBeerForm) {
        this.beerToBeerForm = beerToBeerForm;
    }

    @RequestMapping("/")
    public String redirToHomePage() {
        return "product/homepage";
    }

   /* @RequestMapping("/")
    public String login() {
        return "/product/login";
    }*/


    //PACKAGING/////////////////////////////////////////////////////////////////////

    @RequestMapping({"/packaging/list", "/packaging"})
    public String listPackagings(Model model) {
        model.addAttribute("packagings", packagingService.listAll());
        model.addAttribute("numOfelems", packagingService.numOfElems());
        return "product/listpackaging";
    }


    @RequestMapping("/packaging/show/{id}")
    public String getPackaging(@PathVariable String id, Model model) {
        model.addAttribute("packaging", packagingService.getById(Long.valueOf(id)));
        return "product/showpackaging";
    }

    @RequestMapping("packaging/edit/{id}")
    public String editPackaging(@PathVariable String id, Model model) {
        Packaging packaging = packagingService.getById(Long.valueOf(id));
        PackagingForm packagingForm = packagingToPackagingForm.convert(packaging);

        model.addAttribute("packagingForm", packagingForm);
        return "product/packagingform";
    }

    @RequestMapping("/packaging/new")
    public String newPackaging(Model model) {
        model.addAttribute("packagingForm", new PackagingForm());
        return "product/packagingform";
    }

    @RequestMapping(value = "/packaging", method = RequestMethod.POST)
    public String saveOrUpdatePackaging(@Valid PackagingForm packagingForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "packaging/packagingform";
        }

        Packaging savedPackaging = packagingService.saveOrUpdatePackagingForm(packagingForm);

        return "redirect:/packaging/show/" + savedPackaging.getPackagingTypeId();
    }

    @RequestMapping("/packaging/delete/{id}")
    public String deletePackaging(@PathVariable String id) {
        packagingService.deletePackaging(Long.valueOf(id));
        return "redirect:/packaging/list";
    }
    //////////////////////////////////////////////////////////////////////////////


    //FACTORY/////////////////////////////////////////////////////////////////////

    @RequestMapping({"/factory/list", "/factory"})
    public String listFactories(Model model) {
        model.addAttribute("factories", factoryService.listAll());
        model.addAttribute("numOfelems", factoryService.numOfElems());
        return "product/listfactory";
    }


    @RequestMapping("/factory/show/{id}")
    public String getPFactory(@PathVariable String id, Model model) {
        model.addAttribute("factory", factoryService.getById(Long.valueOf(id)));
        return "product/showfactory";
    }

    @RequestMapping("factory/edit/{id}")
    public String editFactory(@PathVariable String id, Model model) {
        Factory factory = factoryService.getById(Long.valueOf(id));
        FactoryForm factoryForm = factoryToFactoryForm.convert(factory);

        model.addAttribute("factoryForm", factoryForm);
        return "product/factoryform";
    }

    @RequestMapping("/factory/new")
    public String newFactory(Model model) {
        model.addAttribute("factoryForm", new FactoryForm());
        return "product/factoryform";
    }

    @RequestMapping(value = "/factory", method = RequestMethod.POST)
    public String saveOrUpdateFactory(@Valid FactoryForm factoryForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "factory/factoryform";
        }

        Factory savedFactory = factoryService.saveOrUpdateFactoryForm(factoryForm);

        return "redirect:/factory/show/" + savedFactory.getId();
    }

    @RequestMapping("/factory/delete/{id}")
    public String deleteFactory(@PathVariable String id) {
        factoryService.deleteFactory(Long.valueOf(id));
        return "redirect:/factory/list";
    }
    //////////////////////////////////////////////////////////////////////////////


    //MANUFACTURER/////////////////////////////////////////////////////////////////////
    @RequestMapping({"/manufacturer/list", "/manufacturer"})
    public String listMans(Model model) {
        model.addAttribute("manufacturers", manService.listAll());
        model.addAttribute("numOfelems", manService.numOfElems());
        return "product/listmanufacturer";
    }


    @RequestMapping("/manufacturer/show/{id}")
    public String getMan(@PathVariable String id, Model model) {
        model.addAttribute("manufacturer", manService.getById(Long.valueOf(id)));
        return "product/showmanufacturer";
    }

    @RequestMapping("manufacturer/edit/{id}")
    public String editMan(@PathVariable String id, Model model) {
        Man factory = manService.getById(Long.valueOf(id));
        ManForm factoryForm = manToManForm.convert(factory);

        model.addAttribute("manufacturerForm", factoryForm);
        return "product/manufacturerform";
    }

    @RequestMapping("/manufacturer/new")
    public String newMan(Model model) {
        model.addAttribute("manufacturerForm", new ManForm());
        return "product/manufacturerform";
    }

    @RequestMapping(value = "/manufacturer", method = RequestMethod.POST)
    public String saveOrUpdateMan(@Valid ManForm factoryForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "manufacturer/manufacturerform";
        }

        Man savedFactory = manService.saveOrUpdateManForm(factoryForm);

        return "redirect:/manufacturer/show/" + savedFactory.getId();
    }

    @RequestMapping("/manufacturer/delete/{id}")
    public String deleteMan(@PathVariable String id) {
        manService.deleteMan(Long.valueOf(id));
        return "redirect:/manufacturer/list";
    }
    //////////////////////////////////////////////////////////////////////////////


    //BEER TYPE/////////////////////////////////////////////////////////////////////
    @RequestMapping({"/beertype/list", "/beertype"})
    public String listBeerTypes(Model model) {
        model.addAttribute("beertypes", beerTypeService.listAll());
        model.addAttribute("numOfelems", beerTypeService.numOfElems());
        return "product/listbeertype";
    }

    @RequestMapping("/beertype/show/{id}")
    public String getBeerType(@PathVariable String id, Model model) {
        model.addAttribute("beertype", beerTypeService.getById(Long.valueOf(id)));
        return "product/showbeertype";
    }

    @RequestMapping("beertype/edit/{id}")
    public String editBeerType(@PathVariable String id, Model model) {
        BeerType beerType = beerTypeService.getById(Long.valueOf(id));
        BeerTypeForm beerTypeForm = beerTypeToBeerTypeForm.convert(beerType);

        model.addAttribute("beertypeForm", beerTypeForm);
        return "product/beertypeform";
    }

    @RequestMapping("/beertype/new")
    public String newBeerType(Model model) {
        model.addAttribute("beertypeForm", new BeerTypeForm());
        return "product/beertypeform";
    }

    @RequestMapping(value = "/beertype", method = RequestMethod.POST)
    public String saveOrUpdateBeerType(@Valid BeerTypeForm beerTypeForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "beertype/productform";
        }

        BeerType savedBeerType = beerTypeService.saveOrUpdateBeerTypeForm(beerTypeForm);

        return "redirect:/beertype/show/" + savedBeerType.getBeerTypeId();
    }

    @RequestMapping("/beertype/delete/{id}")
    public String deleteBeerType(@PathVariable String id) {
        beerTypeService.deleteBeerType(Long.valueOf(id));
        return "redirect:/beertype/list";
    }
    ///////////////////////////////////////////////////////////////////////////////


    //BEER TYPE HISTORY////////////////////////////////////////////////////////////
    @RequestMapping({"/beertypehistory/list", "/beertypehistory"})
    public String listBeerTypeHistories(Model model) {
        model.addAttribute("beertypehistories", beerTypeHistoryService.listAll());
        model.addAttribute("numOfelems", beerTypeHistoryService.numOfElems());
        return "product/listbeertypehistory";
    }

    @RequestMapping("/beertypehistory/show/{id}")
    public String getBeerTypeHistory(@PathVariable String id, Model model) {
        model.addAttribute("beertypehistory", beerTypeHistoryService.getByIdBeerTypeHistory(Long.valueOf(id)));
        return "product/showbeertypehistory";
    }

    @RequestMapping("beertypehistory/edit/{id}")
    public String editBeerTypeHistory(@PathVariable String id, Model model) {
        BeerTypeHistory beerTypeHistory = beerTypeHistoryService.getByIdBeerTypeHistory(Long.valueOf(id));
        BeerTypeHistoryForm beerTypeHistoryForm = beerTypeHistoryToBeerTypeHistoryForm.convert(beerTypeHistory);

        model.addAttribute("beertypehistoryForm", beerTypeHistoryForm);
        return "product/beertypehistoryform";
    }

    @RequestMapping("/beertypehistory/new")
    public String newBeerTypeHistory(Model model) {
        model.addAttribute("beertypehistoryForm", new BeerTypeHistoryForm());
        return "product/beertypehistoryform";
    }

    @RequestMapping(value = "/beertypehistory", method = RequestMethod.POST)
    public String saveOrUpdateBeerTypeHistory(@Valid BeerTypeHistoryForm beerTypeHistoryForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "beertypehistory/productform";
        }

        BeerTypeHistory savedBeerTypeHistory = beerTypeHistoryService.saveOrUpdateBeerTypeHistoryForm(beerTypeHistoryForm);

        return "redirect:/beertypehistory/show/" + savedBeerTypeHistory.getId();
    }

    @RequestMapping("/beertypehistory/delete/{id}")
    public String deleteBeerTypeHistory(@PathVariable String id) {
        beerTypeHistoryService.deleteBeerTypeHistory(Long.valueOf(id));
        return "redirect:/beertypehistory/list";
    }
    ///////////////////////////////////////////////////////////////////////////////


    //BEER TYPE DESCRIPTION////////////////////////////////////////////////////////////
    @RequestMapping({"/beertypedescription/list", "/beertypedescription"})
    public String listBeerTypeDescr(Model model) {
        model.addAttribute("descriptions", beerTypeDescrService.listAll());
        model.addAttribute("numOfelems", beerTypeDescrService.numOfElems());
        return "product/listbeertypedescription";
    }


    @RequestMapping("/beertypedescription/show/{id}")
    public String getBeerTypeDescr(@PathVariable String id, Model model) {
        model.addAttribute("beertypedescription", beerTypeDescrService.getById(Long.valueOf(id)));
        return "product/showbeertypedescription";
    }

    @RequestMapping("beertypedescription/edit/{id}")
    public String editBeerTypeDescr(@PathVariable String id, Model model) {
        BeerTypeDescr factory = beerTypeDescrService.getById(Long.valueOf(id));
        BeerTypeDescrForm factoryForm = beerTypeDescrToBeerTypeDescrForm.convert(factory);

        model.addAttribute("beertypedescriptionForm", factoryForm);
        return "product/beertypedescriptionform";
    }

    @RequestMapping("/beertypedescription/new")
    public String newBeerTypeDescr(Model model) {
        model.addAttribute("beertypedescriptionForm", new BeerTypeDescrForm());
        return "product/beertypedescriptionform";
    }

    @RequestMapping(value = "/beertypedescription", method = RequestMethod.POST)
    public String saveOrUpdateBeerTypeDescr(@Valid BeerTypeDescrForm factoryForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "beertypedescription/beertypedescriptionform";
        }

        BeerTypeDescr savedFactory = beerTypeDescrService.saveOrUpdateBeerTypeDescrForm(factoryForm);

        return "redirect:/beertypedescription/show/" + savedFactory.getId();
    }

    @RequestMapping("/beertypedescription/delete/{id}")
    public String deleteBeerTypeDescr(@PathVariable String id) {
        beerTypeDescrService.deleteBeerTypeDescr(Long.valueOf(id));
        return "redirect:/beertypedescription/list";
    }


    ///////////////////////////////////////////////////////////////////////////////


    //BEER////////////////////////////////////////////////////////////////////////
    @RequestMapping({"/beer/list", "/beer"})
    public String listBeer(Model model) {
        //List<Beer> beerList= (List<Beer>) beerService.findMaxAlc();
        model.addAttribute("beers", beerService.listAll());
        model.addAttribute("query", beerService.findMaxAlc());
        return "product/listbeer";
    }

    @RequestMapping("/beer/show/{id}")
    public String getBeer(@PathVariable String id, Model model) {
        model.addAttribute("beer", beerService.getByIdBeer(Long.valueOf(id)));
        return "product/showbeer";
    }

    @RequestMapping("beer/edit/{id}")
    public String editBeer(@PathVariable String id, Model model) {
        Beer beer = beerService.getByIdBeer(Long.valueOf(id));
        BeerForm beerForm = beerToBeerForm.convert(beer);

        model.addAttribute("beer", beerForm);
        return "product/beerform";
    }

    @RequestMapping("/beer/new")
    public String newBeer(Model model) {
        model.addAttribute("beer", new BeerForm());
        return "product/beerform";
    }

    @RequestMapping(value = "/beer", method = RequestMethod.POST)
    public String saveOrUpdateBeer(@Valid BeerForm beerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "beer/beerform";
        }

        Beer savedBeer = beerService.saveOrUpdateBeerForm(beerForm);

        return "redirect:/beer/show/" + savedBeer.getId();
    }

    @RequestMapping("/beer/delete/{id}")
    public String deleteBeer(@PathVariable String id) {
        beerService.deleteBeer(Long.valueOf(id));
        return "redirect:/beer/list";
    }
    ///////////////////////////////////////////////////////////////////////////////


    //PRODUCT/////////////////////////////////////////////////////////////////////
    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Product product = productService.getById(Long.valueOf(id));
        ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id) {
        productService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }

    //PRODUCT////////////////////////////////////////////////////////////////////////////
}
