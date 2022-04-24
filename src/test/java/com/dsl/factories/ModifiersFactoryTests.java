package com.dsl.factories;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.models.entities.modifiers.Modifier;

import static org.junit.Assert.assertEquals;

public class ModifiersFactoryTests {
	
	//___________________________________________
    // test_createModifier_Public
    //
    // GIVEN: createModifier is called
    // WHEN:  public type is passed
    // THEN:  PublicModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_Public() throws ModifierNotFoundException {
		//Arrange
		String type = "public";
		
		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("public", modifier.getName());
	}
	
	
	//___________________________________________
    // test_createModifier_Protected
    //
    // GIVEN: createModifier is called
    // WHEN:  protected type is passed
    // THEN:  ProtectedModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_Protected() throws ModifierNotFoundException {
		//Arrange
		String type = "public";

		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("public", modifier.getName());
	}
	
	
	//___________________________________________
    // test_createModifier_Private
    //
    // GIVEN: createModifier is called
    // WHEN:  private type is passed
    // THEN:  PrivateModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_Private() throws ModifierNotFoundException {
		//Arrange
		String type = "private";

		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("private", modifier.getName());
	}
}
