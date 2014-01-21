package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatController;
import chat.model.ChatBot;

/**
 * 
 * @author Berry Echols
 * @version 1.1 10/23/13 Added setupPanel, setupLayout helper methods.
 */
public class ChatbotPanel extends JPanel
{
	/**
	 * Creates a new reference to baseController
	 */
	private ChatController baseController;
	/**
	 * Creates a new reference to appBot
	 */
	private ChatBot appBot;
	/**
	 * Creates a new reference to baseLayout
	 */
	private SpringLayout baseLayout;
	/**
	 * Creates a Jbutton for the submitChatButton
	 */
	private JButton submitChatButton;
	/**
	 * Creates a JTextField called userTextField
	 */
	private JTextField userTextField;
	/**
	 * Creates a new JTextArea called chatArea
	 */
	private JTextArea chatArea;
	/**
	 * Creates a new JScrollPane called chatPane
	 */
	private JScrollPane chatPane;
	/**
	 * creates an int called clickCount
	 */
	private int clickCount;
	
	/**
	 * Creates a ChatbotPanel with a linked ChatbotController object.
	 * @param baseController 
	 */
	public ChatbotPanel(ChatController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();
		
		submitChatButton = new JButton("Click here to type to the chatbot!");
		baseLayout = new SpringLayout();
		userTextField = new JTextField(30);
		chatArea = new JTextArea(10, 30);
		chatPane = new JScrollPane(chatArea);
		
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		setupChat();
	}
	
	/**
	 * Starts the chatbot chat screen with a topic.
	 */
	private void setupChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	/**
	 * Loads all components into the panel and sets the layout manager and color.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(chatPane);
		this.add(submitChatButton);
		this.add(userTextField);
		
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
	}
	
	/**
	 * Creates listeners for all user-interactive objects in the panel.
	 */
	private void setupListeners()
	{
		chatPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent goDown) {
				goDown.getAdjustable().setValue(goDown.getAdjustable().getMaximum());
			}
		});
		/**
		 * Do this when the submitChatButton is clicked!
		 */
		submitChatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();
				chatArea.append(userInput + "\n");
				String processedInput = baseController.processUserInput(userInput);
				
				if(clickCount % 7 == 0)
				{
					String currentPhrase = baseController.dominateTheConversation();
					if(currentPhrase.length() != 0)
					{
						chatArea.append(currentPhrase);
						clickCount--;	
					}
				}
				else if( clickCount % 5 == 0)
				{
					chatArea.append(baseController.memeValidation(userInput) + "\n");
				}
				else if( clickCount % 3 == 0)
				{
					chatArea.append(baseController.colorValidation(userInput) + "\n");
				}
				else if( clickCount % 9 == 0)
				{
					chatArea.append(baseController.foodValidation(userInput) + "\n");
				}
				else
				{			
					chatArea.append(processedInput);
					userTextField.setText("");
					chatArea.append(appBot.getRandomTopic() + "\n");
					
					//This should be a method in the controller that would be returned as a string in the chatArea.
					String me, you, other;
					me = "Berry";
					you = "Ryan";
					other = "Devvin";
					chatArea.append(appBot.putNameInAlphabeticOrder(me,  you,  other) + "\n");
				}
			}
		});
	}
	
	/**
	 * Places all objects with the computer generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 123, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitChatButton, -123, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 17, SpringLayout.SOUTH, userTextField);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 58, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, userTextField, -58, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userTextField, 17, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 17, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 58, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -58, SpringLayout.EAST, this);
	}
}
