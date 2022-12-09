package Projeto_OO;

public class Teste {
	static Ave a1;
	static Cachorro c1;
	static Gato g1;
	
	public static void main(String[] args) {
		
		
		Vacina v1;
		
		a1 = new Ave("Tico","Calopsita",1.5,'M',true,true,false);
		c1 = new Cachorro("Billy","shih tzu",2.0,'M',true,false,"Pequeno");
		g1 = new Gato("Robson","SRD",1.5,'M',true,true,"Curta");
		v1 = new Vacina("Cinomose",true);
		
		
		
		System.out.println(a1.toString());
		System.out.println(c1.toString());
		System.out.println(g1.toString());
		System.out.println(v1.toString());
		
	}

}
