package chat.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Model for the Chatbot project. Contains methods for evaluating Strings.
 * @author Berry Echols
 * @version 1.6 10/30/13
 */

public class ChatBot
{
	/**
	 * Chatbot used for internal chat methods.
	 */
	private ArrayList<String> myMemes;
	private ArrayList<String> myColors;
	/**
	 * Stores a list of random topics
	 */
	private ArrayList<String> myRandomList;
	private ArrayList<String> myFood;
	
	private ArrayList<String> conversationList;
	// Constructor
	
	public ChatBot()
	{
		myMemes = new ArrayList<String>();
		myColors = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		myFood = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		
		fillTheMemeList();
		fillTheColorList();
		fillTheRandomList();
		fillTheFoodList();
		fillTheConversationList();
	}
	/*
	 * Helper method to fill TheConversationList
	 */
	private void fillTheConversationList()
	{
		conversationList.add("Lets talk about you. What is your name?");
		conversationList.add("Seriously? That is a really stupid name.");
		conversationList.add("How old are you?");
		conversationList.add("My goodness! That's quite sad.");
		conversationList.add("How much do you weigh?");
		conversationList.add("Oh, so as much as your mom.");
		conversationList.add("What is your favorite hobby?");
		conversationList.add("Weak. I suggest you look into getting a life.");
		conversationList.add("What kind of personality do you have?");
		conversationList.add("Really? That's actually kind of interesting. Not.");
	}
	/**
	 * Helper method to fill theFoodList
	 */
	private void fillTheFoodList()
	{
		myFood.add("Raspberries");
		myFood.add("Cake");
		myFood.add("AppleSauce");
		myFood.add("Bananas");
	}
	
	/*
	 * Helper method to fill TheRandomList with strings
	 */
	private void fillTheRandomList()
	{
		myRandomList.add("penguins");
		myRandomList.add("I have to say something random?");
		myRandomList.add("You don't want that?");
		myRandomList.add("cat");
	}
	
	/**
	 * Helper method to fill TheMemeList with strings
	 */
	private void fillTheMemeList()
	{
		myMemes.add("My Jimmies are rustled");
		myMemes.add("Cats");
		myMemes.add("What does the fox say");
		myMemes.add("philosoraptor");
		myMemes.add("Iamdisappoint");
		myMemes.add("What does the fox say?");
	}
	
	/**
	 * Helper method that fills the array list with colors
	 */
	private void fillTheColorList()
	{
		myColors.add("red");
		myColors.add("blue");
		myColors.add("green");
		myColors.add("yellow");
		myColors.add("orange");
		myColors.add("purple");
		myColors.add("cyan");
		myColors.add("pink");
		myColors.add("brown");
		myColors.add("Magenta");
		myColors.add("black");
		myColors.add("white");
		myColors.add("beige");
		myColors.add("tan");
		myColors.add("silver");
		myColors.add("gray");
		myColors.add("grey");
		myColors.add("maroon");
		myColors.add("turquoise");
		myColors.add("aquamarine");
		myColors.add("Acid Green");
		myColors.add("Aero");
		myColors.add("Aero Blue");
		myColors.add("African Purple");
		myColors.add("Air Force Blue");
		myColors.add("Air Superiority Blue");
		myColors.add("Alabama Crimson");
		myColors.add("Alice Blue");
		myColors.add("Alizarin Crimson");
		myColors.add("Alloy Orange");
		myColors.add("Almond");
		myColors.add("Amaranth");
		myColors.add("Amaranth Pink");
		myColors.add("Amaranth Purple");
		myColors.add("Amazon");
		myColors.add("Amber");
		myColors.add("American Rose");
		myColors.add("Amethyst");
		myColors.add("Android Green");
		myColors.add("Antique Brass");
		myColors.add("Antique Bronze");
		myColors.add("Baby Blue");
		myColors.add("Baby Pink");
		myColors.add("Banana Yellow");
	}
	
	/**
	 * Method to retrieve a random value from the myRandomList
	 * @return The String value randomly selected from the list.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandomNumber = Math.random();
		int myMemesPosition = (int) (myRandomNumber * myMemes.size());
		randomTopic = myMemes.get(myMemesPosition);
		
		return randomTopic;
	}
	
	/**
	 * Tests if 'currentPhrase' matches any of the values in the Array list
	 * 'myMemes'.
	 * 
	 * @param currentPhrase
	 * is using the 'userInput' String value
	 * @return The boolean that shows whether or not 'currentPhrase' matches
	 * anything in 'myMemes'
	 */
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false;
		
		if(currentPhrase != null)
		{
			for(String currentMeme : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		} 
		return isMeme;
	}
	
	/**
	 * Tests whether or not the String 'current' contains "boo"
	 * @param current phrase
	 * @return Returns a String based on whether or not the String 'current' contains "boo"
	 */
	public String usesContent(String current)
	{
		String processedString = "";
		if(current.contains("boo"))
		{
			processedString = "wooo scary";
		}
		else
		{
			processedString = "booooooring";
		}
		return processedString;
	}
	
	/**
	 * Runs a series of tests to sort Strings alphabetically.
	 * @param String with name of first
	 * @param String with name of middle
	 * @param String with name of last
	 * @return The String sorted name
	 */
	public String putNameInAlphabeticOrder(String first, String middle, String last)
	{
		
		String sortedName = "";
		
		if(first.compareTo(middle) < 0)
		{
			if (first.compareTo(last) < 0)
			{
				if(middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if(last.compareTo(first) <0)
				{
					sortedName = middle + ", " + last + ", " + first;
				}
				else
				{
					sortedName = middle + ", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last = ", " + middle + ", " + first;
			}
		}
		
		return sortedName;
	}
	
	/**
	 * Tests if 'CurrentPhrase' matches any of the values in the Array List
	 * 'MyColors'.
	 * 
	 * @param currentPhrase
	 * is using the 'userInput' String value
	 * @return The boolean that shows whether or not 'currentPhrase' matches
	 * anything in 'myColors'.
	 */
	public boolean colorChecker(String currentPhrase)
	{
		boolean isColor = false;
		
		if(currentPhrase != null)
		{
			for (String currentColor : myColors)
			{
				if (currentPhrase.equalsIgnoreCase(currentColor))
				{
					isColor = true;
				}
			}
		}
		return isColor;
	}
	/**
	 * Tests if 'CurrentPhrase' matches any of the values in the Array List
	 * 'MyFood'.
	 * @param currentPhrase
	 * is using the 'userInput' String value
	 * @return The boolean that shows whether or not 'currentPhrase' matches
	 * anything in 'myFood'.
	 */
	public boolean foodChecker(String currentPhrase)
	{
		boolean isFood = false;
		
		if(currentPhrase != null)
		{
			for (String currentFood : myFood)
			{
				if (currentPhrase.equalsIgnoreCase(currentFood))
				{
					isFood = true;
				}
			}
		}
		return isFood;
	}
	
	public ArrayList<String> conversationPiece()
	{
		return conversationList; 	
	}
}
