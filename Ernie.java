import java.io.*;
import java.util.*;

public class Ernie extends Character implements ArtKid {

    private Map<String, String> map = new HashMap<String, String>();

    public Ernie() {
	super();
	HP = 30;
	def = 0;
	str = 5;
	type = "art";
	talent = "failure";
	name = "Ernie";
	moves = new ArrayList<String>();
	moves.add("Art");
	moves.add("Directly Answer");
	answer = "Where is your answer";

	map.put("\"The Water Lily Pond\"", "Claude Monet");
        map.put("Ballet Rehearsal", "Edgar Degas");
        map.put("\"The Basket of Apples\"", "Paul Cezanne");
        map.put("\"By the Seashore\"", "Pierre Renoir");
        map.put("\"The Potato Eaters\"", "Vincent van Gogh");//5
        map.put("\"The Persistence of Memory\"", "Salvador Dali");
        map.put("Canvas Covered in Paint Drops", "Jackson Pollock");
        map.put("\"Portrait of Adele Bloch-Bauer\"", "Gustave Klimt");
        map.put("The son of Man", "Rene Magritte");
        map.put("Knight, Devil, and Death", "Albrecht Durer");//10
        map.put("\"Girl with a Pearl Earring\"", "Johannes Vermeer");
        map.put("chubby naked ladies", "Peter Paul Rubens");
        map.put("\"The Third of May\"", "Francisco Goya");
        map.put("\"Arnolfini Portrait\"", "Jan Van Eyck");
        map.put("\"Several Circles\"", "Wassily Kandinsky");//15
        map.put("pop art", "Andy Warhol");
        map.put("Garden of Earthly Delights", "Hiernymous Bosch");
        map.put("\"View of Toledo\"", "El Greco");
        map.put("\"American Gothic\"", "Grant Wood");
        map.put("\"I and the Village\"", "Marc Chagall");//20
        map.put("\"The Death of Marat\"", "Jacques-Louis David");
        map.put("houses and train stations", "Edward Hopper");
        map.put("the American flag", "Jasper Johns");
        map.put("\"Self Portrait with a Monkey\"", "Frida Kahlo");
        map.put("murals", "Diego Rivera");//25
        map.put("\"Guernica\"", "Pablo Picasso");
        map.put("\"The Night Watch\"", "Rembrandt Van Rijn");
        map.put("\"Las Meninas\"", "Diego Velazquez");
        map.put("The Calling of St. Matthew", "Caravaggio");
        map.put("The Yellow Christ", "Paul Gauguin");//30
        map.put("\"Olympia\"", "Edouard Manet");
        map.put("Dance", "Henri Matisse");
        map.put("\"School of Athens\"", "Raphael");
        map.put("\"Lady Liberty Leading the People\"", "Eugene Delacroix");
        map.put("readymades", "Marcel Duchamp");//35
        map.put("\"Sunday Afternoon on the Island of La Grand Jatte\"", "Georges Seurat");
        map.put("\"Birth of Venus\"", "Sandro Botticelli");
        map.put("\"Drowning Girl\"", "Roy Lichtenstein");
        map.put("close ups of flowers", "Georgia O'Keefe");
        map.put("ships and storms", "J M W Turner");//40
        map.put("\"The Ambassadors\"", "Hans Holbein the Younger");
        map.put("colorful squares", "Piet Mondrian");
        map.put("\"Black Square\"", "Kazimir Malevich");
        map.put("\"Portrait of Madame X\"", "John Singer Sargeant");
        map.put("\"Ad Parnassum\"", "Paul Klee");//45
        map.put("\"The Four Seasons\"", "Nicolas Poussin");
        map.put("\"Tennis at Newport\"", "George Bellows");
        map.put("portraits of people in pain", "Francis Bacon");
        map.put("\"Red Headed Girl in Evening\"", "Modigliani");
        map.put("\"The Hunters in the Snow\"", "Pieter Bruegel the Elder");//50
    }
	
    public String about() {
        String ernie = "";
	ernie += "Your name is Ernie.\n";
	ernie += "You get offended easily, but you're more or less a good teammate.\n";
	ernie += "BLin recruited you after you repeatedly asked him through facebook.\n";
	ernie += "Now you are ready to help him and the rest of the squad to make sure BLin has a great prom night.\n";
	return ernie;
    }

        
    public String specialOne(String a, String b) {
    	answer = a;
    	return answer;
    }
    public String specialTwo(String a, String b){
    	return "please work";
    }
}
