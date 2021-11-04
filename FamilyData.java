package familyStucture;


import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import familyStucture.FamilyMember.Gender;



public class FamilyData {

	public static Collection<FamilyMember> getAllFamilyMember(){
		
		FamilyMember king = new FamilyMember();
		FamilyMember queen = new FamilyMember();
		FamilyMember Chit = new FamilyMember();
		FamilyMember Amba = new FamilyMember();
		FamilyMember Ish = new FamilyMember();
		FamilyMember Vich = new FamilyMember();
		FamilyMember Lika = new FamilyMember();
		FamilyMember Aras = new FamilyMember();
		FamilyMember Chitra = new FamilyMember();
		FamilyMember Satya = new FamilyMember();
		FamilyMember Vyan = new FamilyMember();
		FamilyMember Dritha = new FamilyMember();
		FamilyMember Jaya = new FamilyMember();
		FamilyMember Tritha = new FamilyMember();
		FamilyMember Vritha = new FamilyMember();
		FamilyMember Vila = new FamilyMember();
		FamilyMember Chika = new FamilyMember();
		FamilyMember Arit = new FamilyMember();
		FamilyMember Jnki = new FamilyMember();
		FamilyMember Ahit = new FamilyMember();
		FamilyMember Satvy = new FamilyMember();
		FamilyMember Asva = new FamilyMember();
		FamilyMember Krpi = new FamilyMember();
		FamilyMember Vyas = new FamilyMember();
		FamilyMember Atya = new FamilyMember();
		FamilyMember Yodhan = new FamilyMember();
		FamilyMember Laki = new FamilyMember();
		FamilyMember Lavnya = new FamilyMember();
		FamilyMember Vasa = new FamilyMember();
		FamilyMember Kriya = new FamilyMember();
		FamilyMember Krithi = new FamilyMember();
		
		List<FamilyMember> kingQueenChildren = new ArrayList<FamilyMember>();
		kingQueenChildren.add(Chit);
		kingQueenChildren.add(Ish);
		kingQueenChildren.add(Vich);
		kingQueenChildren.add(Aras);
		kingQueenChildren.add(Satya);
		
		List<FamilyMember> chitAmbaChildren = new ArrayList<FamilyMember>();
		chitAmbaChildren.add(Dritha);
		chitAmbaChildren.add(Tritha);
		chitAmbaChildren.add(Vritha);
		
		List<FamilyMember> vichLikaChildren = new ArrayList<FamilyMember>();
		vichLikaChildren.add(Vila);
		vichLikaChildren.add(Chika);
		
		List<FamilyMember> arasChitraChildren = new ArrayList<FamilyMember>();
		arasChitraChildren.add(Jnki);
		arasChitraChildren.add(Ahit);
		
		List<FamilyMember> satyaVyanChildren = new ArrayList<FamilyMember>();
		satyaVyanChildren.add(Asva);
		satyaVyanChildren.add(Vyas);
		satyaVyanChildren.add(Atya);
		
		List<FamilyMember> drithaJayaChildren = new ArrayList<FamilyMember>();
		drithaJayaChildren.add(Yodhan);
		
		List<FamilyMember> aritJnkiChildren = new ArrayList<FamilyMember>();
		aritJnkiChildren.add(Laki);
		aritJnkiChildren.add(Lavnya);
		
		List<FamilyMember> satvyAsvaChildren = new  ArrayList<FamilyMember>();
		satvyAsvaChildren.add(Vasa);
		
		List<FamilyMember> krpiVyasChildren = new ArrayList<FamilyMember>();
		krpiVyasChildren.add(Kriya);
		krpiVyasChildren.add(Krithi);
		 
		king = fillUpDetails(king,"Shan",Gender.Male,null,null,kingQueenChildren,queen);
		queen = fillUpDetails(queen,"Anga",Gender.Male,null,null,kingQueenChildren,king);
		Chit = fillUpDetails(Chit,"Chit",Gender.Male,queen,king,chitAmbaChildren,Amba);
		Amba = fillUpDetails(Amba,"Amba",Gender.Female,null,null,chitAmbaChildren,Chit);
		Ish = fillUpDetails(Ish,"Ish",Gender.Male,queen,king,null,null);
		Vich = fillUpDetails(Vich,"Vich",Gender.Male,queen,king,vichLikaChildren,Lika);
		Lika = fillUpDetails(Lika,"Lika",Gender.Female,null,null,vichLikaChildren,Vich);
		Aras = fillUpDetails(Aras,"Aras",Gender.Male,queen,king,arasChitraChildren,Chitra);
		Chitra = fillUpDetails(Chitra,"Chitra",Gender.Female,null,null,arasChitraChildren,Aras);
		Satya = fillUpDetails(Satya,"Satya",Gender.Female,queen,king,satyaVyanChildren,Vyan);
		Vyan = fillUpDetails(Vyan,"Vyan",Gender.Male,null,null,satyaVyanChildren,Satya);
		Dritha = fillUpDetails(Dritha,"Dritha",Gender.Female,Amba,Chit,drithaJayaChildren,Aras);
		Jaya = fillUpDetails(Jaya,"Jaya",Gender.Male,null,null,drithaJayaChildren,Dritha);
		Tritha = fillUpDetails(Tritha,"Tritha",Gender.Female,Amba,Chit,null,null);
		Vritha = fillUpDetails(Vritha,"Vritha",Gender.Male,Amba,Chit,null,null);
		Vila = fillUpDetails(Vila,"Vila",Gender.Female,Lika,Vich,null,null);
		Chika = fillUpDetails(Chika,"Chika",Gender.Female,Lika,Vich,null,null);
		Arit = fillUpDetails(Arit,"Arit",Gender.Male,null,null,aritJnkiChildren,Jnki);
		Jnki = fillUpDetails(Jnki,"Jnki",Gender.Female,Chitra,Aras,aritJnkiChildren,Arit);
		Ahit = fillUpDetails(Ahit,"Ahit",Gender.Male,Chitra,Aras,null,null);
		Satvy = fillUpDetails(Satvy,"Satvy",Gender.Female,null,null,satvyAsvaChildren,Asva);
		Asva = fillUpDetails(Asva,"Asva",Gender.Male,Satya,Vyan,satvyAsvaChildren,Satvy);
		Krpi = fillUpDetails(Krpi,"Krpi",Gender.Female,null,null,krpiVyasChildren,Vyas);
		Vyas = fillUpDetails(Vyas,"Vyas",Gender.Male,Satya,Vyan,krpiVyasChildren,Krpi);
		Atya = fillUpDetails(Atya,"Atya",Gender.Female,Satya,Vyan,null,null);
		Yodhan = fillUpDetails(Yodhan,"Yodhan",Gender.Male,Dritha,Jaya,null,null);
		Laki = fillUpDetails(Laki,"Laki",Gender.Male,Jnki,Arit,null,null);
		Lavnya = fillUpDetails(Lavnya,"Lavnya",Gender.Female,Jnki,Arit,null,null);
		Vasa = fillUpDetails(Vasa,"Vasa",Gender.Male,Satvy,Asva,null,null);
		Kriya = fillUpDetails(Kriya,"Kriya",Gender.Male,Krpi,Asva,null,null);
		Krithi = fillUpDetails(Krithi,"Krithi",Gender.Female,Krpi,Vyas,null,null);
		
		List<FamilyMember>  allFamilyMembers = new ArrayList<FamilyMember>();
		Collections.addAll(allFamilyMembers, king,queen,Chit,Amba,Ish,Vich,Lika,Aras,
				Chitra,Satya,Vyan,Dritha,Jaya,Tritha,Vritha,Vila,Chika,Arit,Jnki,Ahit,Satvy,Asva,Krpi,Vyas,Atya,Yodhan,
				Laki,Lavnya,Vasa,Kriya,Krithi);
		
		return allFamilyMembers;
		
	}
	
	public static FamilyMember fillUpDetails(FamilyMember member,String  name, Gender gender,FamilyMember mother,
			FamilyMember father,Collection<FamilyMember> children,FamilyMember spouse) {
	
		member.setName(name);
		member.setGender(gender);
		member.setMother(mother);
		member.setFather(father);
		member.setSpouse(spouse);
		member.setChildren(children);
		return member;
	};

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

