public class DDTest{

public static void main(String[] args){

Wizard Harry = new Wizard(); 
Samurai Chuck = new Samurai(); 
Ninja Bruce = new Ninja(); 

Harry.fireball(Chuck);
System.out.println(Chuck.health);
Chuck.deathBlow(Harry);
System.out.println(Harry.health);
}

}