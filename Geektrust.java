package familyStucture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import familyStucture.FamilyMember.Gender;

public class Geektrust {

	public static void main(String[] args) {
		File file = new File(args[0] + "\\test.txt");
		  try
		  {
			 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			
			while((st = br.readLine()) != null)
			{
				String[] params=st.split("\\s+");
				if(params[0].equalsIgnoreCase("ADD_CHILD"))
				{
					addChildToMother(params[1],params[2],params[3]);
				}
				if(params[0].equalsIgnoreCase("GET_RELATIONSHIP"))
				{
					getRelationships(params[1],params[2]);
				}
			}
		  }
		catch(IOException e)
		{
			e.printStackTrace();
		}
  }
	
	
	private static void getRelationships(String name,String relation)
	{
		FamilyMember member = getFamilyMemberByName(name);
		if(relation.equalsIgnoreCase("Paternal-Uncle"))
		{
			getParentalUncles(member);
		}
		if(relation.equalsIgnoreCase("Maternal-Uncle"))
		{
			getMaternalUncles(member);
		}
		if(relation.equalsIgnoreCase("Paternal-Aunt"))
		{
			getParentalAunts(member);
		}
		if(relation.equalsIgnoreCase("Maternal-Aunt"))
         {
			  getMaternalAunts(member);
          }
		if(relation.equalsIgnoreCase("Son"))
		{
			getSons(member);
		}
		if(relation.equalsIgnoreCase("Daughter"))
		{
			getDaughters(member);
		}
		if(relation.equalsIgnoreCase("Siblings"))
		{
			getSiblings(member);
		}
		if(relation.equalsIgnoreCase("Sister-In-Law"))
		{
			getSisterInLaws(member);
		}
		if(relation.equalsIgnoreCase("Brother-In-Law"))
		{
			getBrotherInLaws(member);
		}
		
		
	}
	
	private static void getSons(FamilyMember member) {
		Collection<FamilyMember> sons = member.getChildren() != null ? member.getChildren().stream().filter(m -> m.getGender().equals(Gender.Male)).collect(Collectors.toList())
				: null;
		if (sons != null) {
			System.out.println(getNames(sons));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	private static void getDaughters(FamilyMember member) {
		Collection<FamilyMember> Daughters = member.getChildren() != null ? member.getChildren().stream().filter(m -> m.getGender().equals(Gender.Female)).collect(Collectors.toList())
				: null;
		if (Daughters != null) {
			System.out.println(getNames(Daughters));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	
	
	private static void getSiblings(FamilyMember member) {
		Collection<FamilyMember> children = member.getFather().getChildren();
		if (children != null) {
			children.remove(member);
			System.out.println(getNames(children));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	private static void getSisterInLaws(FamilyMember member) {
		List<FamilyMember> siblingWives = new ArrayList<>();
		List<FamilyMember> brothers = member.getFather().getChildren().stream().filter(m->m.getGender().equals(Gender.Male)).collect(Collectors.toList());
		if(brothers!=null) {
			brothers.remove(member);
		}
		for (FamilyMember brother : brothers) {
			siblingWives.add(brother.getSpouse());
		}
		
		List<FamilyMember> sisterInLaws = new ArrayList<>();
		
		sisterInLaws.addAll(siblingWives);
		
		if (!sisterInLaws.isEmpty()) {
			System.out.println(getNames(sisterInLaws));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	
	
	
	private static void getBrotherInLaws(FamilyMember member) {
		List<FamilyMember> siblingHusbands = new ArrayList<>();
		
		List<FamilyMember> sisters = member.getFather().getChildren().stream().filter(m->m.getGender().equals(Gender.Female)).collect(Collectors.toList());
		if(sisters!=null) {
			sisters.remove(member);
		}
		for (FamilyMember sister : sisters) {
			siblingHusbands.add(sister.getSpouse());
		}
		
		List<FamilyMember>  brotherInLaws = new ArrayList<>();
		
		brotherInLaws.addAll(siblingHusbands);
		
		if (!brotherInLaws.isEmpty()) {
			System.out.println(getNames(brotherInLaws));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	
	
	private static void getParentalUncles(FamilyMember member) {

		FamilyMember grandFather = null;
		if (null != member) {
			grandFather = getGrandFather(member);
		}

		Collection<FamilyMember> grandChildren = grandFather != null ? grandFather.getChildren() : null;
		Collection<FamilyMember> uncles = grandChildren != null
				? grandChildren.stream().filter(m -> m.getGender().equals(Gender.Male)).collect(Collectors.toList())
				: null;
		if (uncles != null) {
			uncles.remove(member.getFather());
			System.out.println(getNames(uncles));
		}
		else {
			System.out.println("NONE");
		}
	}
	
	private static FamilyMember getGrandFather(FamilyMember member)	{
		FamilyMember father = null;
		if(null != member) {
			father = member.getFather();
		}
		return father != null ? father.getFather() : null;
		
	}
	
	
	private static void getMaternalUncles(FamilyMember member) {

		FamilyMember grandMother = null;
		if (null != member) {
			grandMother = getGrandMother(member);
		}

		Collection<FamilyMember> grandChildren = grandMother != null ? grandMother.getChildren() : null;
		Collection<FamilyMember> uncles = grandChildren != null
				? grandChildren.stream().filter(m -> m.getGender().equals(Gender.Male)).collect(Collectors.toList())
				: null;
		
		if (uncles != null) {
			System.out.println(getNames(uncles));
		}
		else {
			System.out.println("NONE");
		}
	}
	
private static FamilyMember getGrandMother(FamilyMember member)	{
	FamilyMember mother = null;
	if(null != member) {
		mother = member.getMother();
	}
	return mother != null ? mother.getMother() : null;
	
}



private static void getParentalAunts(FamilyMember member) {

	FamilyMember grandFather = null;
	if (null != member) {
		grandFather = getGrandFather(member);
	}

	Collection<FamilyMember> grandChildren = grandFather != null ? grandFather.getChildren() : null;
	Collection<FamilyMember> aunts = grandChildren != null
			? grandChildren.stream().filter(m -> m.getGender().equals(Gender.Female)).collect(Collectors.toList())
			: null;
	if (aunts != null) {
		System.out.println(getNames(aunts));
	}
	else {
		System.out.println("NONE");
	}
}


private static void getMaternalAunts(FamilyMember member) {

	FamilyMember grandMother = null;
	if (null != member) {
		grandMother = getGrandMother(member);
	}

	Collection<FamilyMember> grandChildren = grandMother != null ? grandMother.getChildren() : null;
	Collection<FamilyMember> aunts = grandChildren != null
			? grandChildren.stream().filter(m -> m.getGender().equals(Gender.Female)).collect(Collectors.toList())
			: null;
	if (aunts != null) {
		aunts.remove(member.getMother());
		System.out.println(getNames(aunts));
	}
	else {
		System.out.println("NONE");
	}
}




	
private static FamilyMember getFamilyMemberByName(String name)	{
	Collection<FamilyMember>   allFamilyMembers = FamilyData.getAllFamilyMember();
	return allFamilyMembers.stream().filter(member -> name.equals(member.getName())).findAny().orElse(null);
}
	
private static void addChildToMother(String motherName,String name,String gender) {
	Collection<FamilyMember> allFamilyMembers = FamilyData.getAllFamilyMember();
	Predicate<FamilyMember> nameFilter = member -> motherName.equals(member.getName());
	Predicate<FamilyMember> genderFilter = member ->Gender.Female.equals(member.getGender());
	FamilyMember mother = allFamilyMembers.stream().filter(nameFilter.and(genderFilter)).findAny().orElse(null);
	if(mother != null && mother.getSpouse() !=null) {
		FamilyMember child = new FamilyMember();
		FamilyData.fillUpDetails(child, name, Gender.valueOf(gender), mother, mother.getSpouse(), null, null);
		if(Collections.addAll(allFamilyMembers,child)) {
			System.out.println("CHILD_ADDITION_SUCCEEDED");
			System.out.println(child.getName());
		}
	}
	else {
		System.out.println("CHILD_ADDITION_FAILD");
	}	
}
private static String getNames(Collection<FamilyMember> members) {
	String names = "";
	for(FamilyMember member: members) {
		names += "\"" + member.getName() + "\"";
	}
	return names.substring(0,names.length() - 2);
}
}

 

	
	
	
	
	
	
	
	
	
	
	
