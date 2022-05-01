package com.dsl.tests.models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import com.dsl.models.modifiers.AbstractModifier;
import com.dsl.models.modifiers.Modifier;
import com.dsl.models.modifiers.PrivateModifier;
import com.dsl.models.modifiers.ProtectedModifier;
import com.dsl.models.modifiers.PublicModifier;
import com.dsl.models.modifiers.StaticModifier;

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
	
	//_____________________________________________
    // test_getName_StaticModifier
    //
    // GIVEN: getName is called
    // WHEN:  Static instance is executed
    // THEN:  name returned will be static
    //_____________________________________________
	@Test
	public void test_getName_StaticModifier() {
		//Arrange
		Modifier modifier = new StaticModifier();
		
		//Act
		String modifierName = modifier.getName();
		
		//Assert
		assertEquals("static", modifierName);
	}
	
	//_____________________________________________
    // test_getName_AbstractModifier
    //
    // GIVEN: getName is called
    // WHEN:  Abstract instance is executed
    // THEN:  name returned will be abstract
    //_____________________________________________
	@Test
	public void test_getName_AbstractModifier() {
		//Arrange
		Modifier modifier = new AbstractModifier();
		
		//Act
		String modifierName = modifier.getName();
		
		//Assert
		assertEquals("abstract", modifierName);
	}
}
