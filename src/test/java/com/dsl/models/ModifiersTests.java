package com.dsl.models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.dsl.models.entities.modifiers.Modifier;
import com.dsl.models.entities.modifiers.PrivateModifier;
import com.dsl.models.entities.modifiers.ProtectedModifier;
import com.dsl.models.entities.modifiers.PublicModifier;

public class ModifiersTests {

	//_____________________________________________
    // test_getName_PublicModifier
    //
    // GIVEN: getName is called
    // WHEN:  PublicModifier instance is executed
    // THEN:  name returned will be public
    //_____________________________________________
	@Test
	public void test_getName_PublicModifier() {
		//Arrange
		Modifier modifier = new PublicModifier();
		
		//Act
		String modifierName = modifier.getName();
		
		//Assert
		assertEquals("public", modifierName);
	}
	
	//_____________________________________________
    // test_getName_PrivateModifier
    //
    // GIVEN: getName is called
    // WHEN:  PrivateModifier instance is executed
    // THEN:  name returned will be private
    //_____________________________________________
	@Test
	public void test_getName_PrivateModifier() {
		//Arrange
		Modifier modifier = new PrivateModifier();
		
		//Act
		String modifierName = modifier.getName();
		
		//Assert
		assertEquals("private", modifierName);
	}
	
	//_____________________________________________
    // test_getName_ProtectedModifier
    //
    // GIVEN: getName is called
    // WHEN:  Protected instance is executed
    // THEN:  name returned will be protected
    //_____________________________________________
	@Test
	public void test_getName_ProtectedModifier() {
		//Arrange
		Modifier modifier = new ProtectedModifier();
		
		//Act
		String modifierName = modifier.getName();
		
		//Assert
		assertEquals("protected", modifierName);
	}
}
