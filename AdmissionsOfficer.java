public class AdmissionsOfficer extends Monster{
    
    public AdmissionsOfficer() {
        super();
        HP = 200; 
        def = 50;
        str = 150;
        //too op
    }
    
    //you can fight them, or you can go on expedition to find object
    //this object will bypass the Admissions officers
    
    public String about() {
        String story = "\n";
        story += "Admissions Officers appear in the vicinity of Rubik's Cube's prison.\n";
        story += "They serve to prevent entry by any means necessary.\n";
        return story;
    }
    
    
}
