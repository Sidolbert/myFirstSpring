package com.csm.enrici.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//déclare un contrôleur MVC
@Controller
public class myFirstController {

	//déclare que les url /index et / en requête HTTP Get correspondra à ma fonction getIndex
	@GetMapping(value= {"/", "/index"})
	//version plus détaillée
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	public String getIndex() {
		//la méthode retourne une String correspondant à un nom de vue
		return "index";
		
	}
	
	@GetMapping("/welcome")
	//l'annotation @RequestParam permet de récupérer dans le code de la méthode un paramètre de requête HTTP
	//ici, un paramètre name ou, s'il est vide, la String "toto"
	//le paramètre Model permettra de gérer l'utilisation de données entre les requêtes
	public String getWelcome(@RequestParam(name = "name", defaultValue = "toto", required =false) String name, Model model) {
		System.out.println(name);
		//je transfère au modèle la variable où j'avais rangé le paramètre de requête
		model.addAttribute("name", name);
		return "welcome";
	}
}
