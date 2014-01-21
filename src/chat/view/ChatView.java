package chat.view;

import javax.swing.JOptionPane;
import chat.model.ChatBot;

/**
 * GUI View for the Chatbot project
 * 
 * @author Berry Echols
 * @version 1.3 10/12/13
 *
 */

public class ChatView
{
	private ChatBot myChatbot;
	
	public ChatView()
	{
		myChatbot = new ChatBot();
	}
	
	public void showChatController()
	{
		String input = "keep going";
		
		while(input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null,  myChatbot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		
		myChatbot.conversationPiece();
	}
	
	public void showApp()
	{
		String input = "keep going";
		
		while(input == null || !input.equals("nothing"))
		{
			JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		
		myChatbot.conversationPiece();
	}
	
	private String getInput()
	{
		String input = "";
		
		input = JOptionPane.showInputDialog("What do you want to talk about?");
		
		return input;
	}
	
	private void useInput(String userInput)
	{
		if(myChatbot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput + " is a meme!!!");
		}
		else if(myChatbot.colorChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "Wow! " + userInput + " is my favorite color!!!");
		}
		JOptionPane.showMessageDialog(null, "Wow that is so interesting that you want to talk with me about " + userInput);
	}
}
