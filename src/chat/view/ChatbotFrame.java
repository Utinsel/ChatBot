package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatController;

public class ChatbotFrame extends JFrame
{
	/**
	 * Creates a reference to the baseController.
	 */
	private ChatController baseController;
	/**
	 * Creates a new ChatbotPanel named basePanel.
	 */
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	/**
	 * Sets all the properties of the Frame
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
