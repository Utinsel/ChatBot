package chat.controller;

import java.util.ArrayList;

import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatbotFrame;

/**
 * 
 * @author Berry Echols
 * @version 1.5 10/31/13 Adding Model to the project and changed GUI load. Added a getter for the Chatbot.
 * Removed the references to the popup view. Added documentation. Added conversation helper and memeValidation.
 */
 
public class ChatController
{
	/**
	 * The application frame for the Chatbot program.
	 */
	private ChatbotFrame appFrame;
	/**
	 * The main chatbot for the application.
	 */
	private ChatBot appBot;
	
	/**
	 * Creates a ChatbotController and initializes the Chatbot model instance.
	 */
	public ChatController()
	{
		appBot = new ChatBot();
	}
	
	/**
	 * Getter method for the Chatbot instance.
	 * @return The Chatbot for the application.
	 */
	
	public ChatBot getAppBot()
	{
		return appBot;
	}

	/**
	 * Initializes the ChatbotFrame for the GUI.
	 */
	public void start()
	{
		appFrame = new ChatbotFrame(this);
	}
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talking about the memes?";
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is the coolest meme huh";
		}
		return memeReaction;
	}
	
	public String colorValidation(String currentInput)
	{
		String colorReaction = "Why aren't you talking about the colors?";
		if(appBot.colorChecker(currentInput))
		{
			colorReaction = currentInput + " is the coolest color huh";
		}
		return colorReaction;
	}
	
	public String foodValidation(String currentInput)
	{
		String foodReaction = "Why aren't you talking about the food?";
		if(appBot.foodChecker(currentInput))
		{
			foodReaction = currentInput + " is the coolest food huh";
		}
		return foodReaction;
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());
		
		
		return currentConversationPiece;
	}
	/**
	 * Tests whether or not currentInput equals any of the checkers.
	 * @param currentInput is the latest input of the user.
	 * @return Returns a String if the current input equals any of the checkers.
	 */
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if (appBot.memeChecker(currentInput))
		{
			response = "memes!!!!";
		}
		else if(true)
		{
			
		}
		
		return response;
	}
}
