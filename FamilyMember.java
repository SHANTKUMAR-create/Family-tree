package familyStucture;


import java.util.Collection;

public class FamilyMember {
	
	public enum Gender{
		Male,Female
	}

	
	private String name;
	private FamilyMember mother;
	private FamilyMember father;
	private Collection<FamilyMember> children;
	private FamilyMember spouse;
	private Gender gender;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name= name;
	}
	
	public FamilyMember getMother()
	{
		return mother;
	}
	
	
	public void setMother(FamilyMember mother)
	{
		this.mother=mother;
	}
	
	public FamilyMember getFather()
	{
		return father;
	}
	
	public void setFather(FamilyMember father)
	{
		this.father=father;
	}
	
	public Collection<FamilyMember> getChildren()
	{
		return children;
	}
	
	public void setChildren(Collection<FamilyMember> children) {
		this.children=children;
	}
	
	public FamilyMember getSpouse()
	{
		return spouse;
	}
	public void setSpouse(FamilyMember spouse)
	{
		this.spouse=spouse;
	}
	
	public Gender getGender()
	{
		return gender;
	}
	
	public void setGender(Gender gender)
	{
		this.gender=gender;
	}
}
	
