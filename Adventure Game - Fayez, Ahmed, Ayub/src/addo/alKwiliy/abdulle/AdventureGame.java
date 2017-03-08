package addo.alKwiliy.abdulle;

import hsa_new.Console;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AdventureGame {

	public static void main(String[] args) {
		String playAgain = "";
		try {
			Console c = new Console();

			do {
				c.clear();
				// Introduction to game
				c.println("This is a story about your career, the choices you make will change the outcome of your life... \n \nYou are a college basketball player, you're playing a championship game and there's 10 seconds left and your team is down 2, and the coach has decided your taking the final shot. There are many scouts at the game watching your every move. What do you do? (If you want to take a three pointer to win type in 'shot', if you want to tie the game with a layup and go into overtime type in 'layup')");
				c.println();
				// Major Variables
				int random;
				//NBA Pays, and Teams
				String[] team = {"Philadelphia 76ers", "Los Angeles Lakers","Cleveland Cavaliers","New York Knicks","Golden State Warriors,","Minnesota Timberwolves"};
				int [] pay = {10,11,9,7,5,8};
				//Theme making
				Clip theme = AudioSystem.getClip();
				;

				// create the clip object
				theme.open(AudioSystem.getAudioInputStream(new File("NBA_game_crowd_sound_effect_-_normal.wav")));

				// Primary decision
				String finalShot = c.readLine();
				c.println();
				// take shot routes and variables
				String philTrade;
				String lakersChoice;
				//lay up route variables
				String stayOnTeam;
				String followPlay;
				String careerDecision;
				String knicksTrade;
				String wolfChoice;
				//shot decision
				if (finalShot.equalsIgnoreCase("Shot")) {
					//random number for chance of hitting shot
					random = (int) (Math.random() * 4 + 1);
					//if the shot hits
					if (random == 4) {
						c.clear();
						c.println("YOU HIT THE SHOT!");
						theme.start();
						Thread.sleep(5000);
						c.clear();
						c.println("Scouts were impressed by your performance! \n\n You were drafted as the 1st pick in the 2017 draft to the "+team[0]+". Your income is $"+pay[0]+" would you like to trade to a different team?");
						c.println();
						c.println("(Type in 'yes' if you would like to trade or type in 'no' if you would not like to trade)");
						c.println();
						philTrade = c.readLine();
						c.clear();
						//team trades
						if (philTrade.equalsIgnoreCase("Yes")) {
							c.println(
									"Both the " +team[2]+ " and the " +team[1]+ " are willing to take you.\n\nThe  are " +team[2]+" are offering $"+pay[2]+" mill/a and the "+team[1]+" are offering $"+pay[1]+" mill/a. \n(Type 'cavs' if you select "+team[2]+" or type in 'lakers' for the "+team[1]+")");

							c.println();
							lakersChoice = c.readLine();
							if (lakersChoice.equalsIgnoreCase("Lakers")) {
								c.clear();
								c.println("Congratulations!! Welcome to the "+team[1]+". Your annual salary is $"+pay[1]+" million!");
								Thread.sleep(5000);
								c.println();
								c.println("This is the end of your story, you are playing for the "+team[1]+" as a substitute Point Guard who makes $"+pay[1]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
								playAgain = c.readLine();

							} else if (lakersChoice.equalsIgnoreCase("Cavs")) {
								c.clear();
								c.println("Congratulations!! Welcome to the "+team[2]+". Your annual salary is "+pay[2]+" million!");
								Thread.sleep(5000);
								c.println();
								c.println("This is the end of your story, you are playing for the "+team[2]+" as a substitute Point Guard who makes $"+pay[2]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
								playAgain = c.readLine();

							}

						}
						//trade decline
						else if (philTrade.equalsIgnoreCase("no")){

							c.clear();
							c.println("Congratulations!! Welcome to the "+team [0]+". Your annual salary is $"+pay[0]+" million!");
							Thread.sleep(5000);
							c.println();
							c.println("This is the end of your story, you are playing for the "+team[0]+" as a starting Point Guard who makes $"+pay[0]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
							playAgain = c.readLine();
						}
					} 
					//shot doesn't hit
					else {
						c.clear();
						c.println("You missed and cost your team the game.");
						Thread.sleep(5000);
						c.clear();
						c.println("This is the end of your story, You don't make it into the NBA this year but you still play for your college team. There's always next year! \n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no') ");
						playAgain = c.readLine();
					}
				}
				//layup decision
				else if (finalShot.equalsIgnoreCase("layup")){
					random=(int)(Math.random()*4+1);
					//if layup fails
					if(random==4){
						c.clear();
						c.println("While going for the layup, you get fouled and have to take free throws.\n\nYou ended up missing both shots and everyone boo's you.");
						Thread.sleep(5000);
						c.clear();		
						c.println("After the game your coach decides to kick you from the team. Do you accept getting kicked out or beg your coach to let you stay\n(Type in 'beg' to beg your coach or type in 'accept' to accept getting kicked");
						stayOnTeam=c.readLine();
						if(stayOnTeam.equalsIgnoreCase("beg")){
							c.clear();
							c.println("You get laughed at and are humiliated in front of everyone. Guess you're not on the team anymore.\n\nYou decide to apply for another college who will actually respect your skill.\n\nYou've been accepted into this college. They had a way better team anyway. Good luck at tryouts!!");
							Thread.sleep(10000);
							c.clear();
							c.println("This is the end of your story, You've applied for another college team and have made it!\n You're not a starter, but if you keep up the good work you will be there in no time!\n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no') ");
							playAgain = c.readLine();  

						}
						else if(stayOnTeam.equalsIgnoreCase("accept")){
							c.clear();
							c.println("No more college basketball for you now, maybe you're more suited for another career.\nBetter get those grades up.");
							c.println();
							c.println("This is the end of your story. You end up working at McDonalds for minimum wage. Told you to get those grades up!\n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no' ");
							playAgain = c.readLine();  

						}
					}
					//if layup goes in
					else {
						c.clear();
						c.println("You tied the game and are going into overtime.");
						theme.start();
						Thread.sleep(5000);
						c.clear();
						c.println("In overtime you get subbed off for the first several minutes. \nYou are put in for the final minutes of the game. Your coach gives you a play, but you doubt it'll work.\nDo you follow it? (type in 'yes' or 'no')");
						followPlay=c.readLine();
						//follow the play
						if(followPlay.equalsIgnoreCase("yes")){
							random=(int)(Math.random()*4+1);
							//chances of play failing
							if (random==4){
								c.clear();
								c.println("You guys lose. Ah well you tried your best right?");
								Thread.sleep(5000);
								c.clear();
								c.println("Time passes and you graduate from college. You've spent a lot of your time in school studying social sciences, but are very qualified to be a basketball coach. \nDo you wish to become a high school basketball coach or a behaviour management worker?\n(Type 'basketball' to become a coach or type 'management' to become a behaviour management worker)");		
								careerDecision = c.readLine();
								if (careerDecision.equalsIgnoreCase("basketball")){
									c.clear();
									c.println("Congratulations, this is the end of your story. You chose to become a high school basketball coach, and have become really successful.\nYour annual salary is $75k/a \n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
									playAgain=c.readLine();
								}
								else if(careerDecision.equalsIgnoreCase("managment")){
									c.clear();
									c.println("Congratulations, this is the end of your story. You chose to become a behaviour managment worker who earns $65k/a \nHowever, after a year on the job one of your clients beat you up. You get hospitalized for a year, but you'll be fine!\n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
									playAgain=c.readLine();
								}

							}
							//the play works
							else{
								c.clear();
								c.println("YOU GUYS WON!!! Your team and scouts are really impressed about your performance. You have quite a life coming ahead of you! ");
								theme.start();
								Thread.sleep(10000);
								c.clear();
								c.println("You were drafted as the 1st pick in the 2017 draft to the "+team[3]+". Your income is $"+pay[3]+" mill/a would you like to trade to a different team?");
								c.println();
								c.println("(Type in 'yes' if you would like to trade or type in 'no' if you would not like to trade)");
								c.println();
								knicksTrade = c.readLine();
								c.clear();
								//team trading 
								if (knicksTrade.equalsIgnoreCase("Yes")) {
									c.println("Both the " +team[5]+ " and the " +team[4]+ " are willing to take you.\n\nThe  are " +team[5]+" are offering $"+pay[5]+" mill/a and the "+team[4]+" are offering $"+pay[4]+" mill/a. \n(Type 'warrior' if you select "+team[4]+" or type in 'wolf' for the "+team[5]+")");
									c.println();
									wolfChoice = c.readLine();
									if (wolfChoice.equalsIgnoreCase("wolf")) {
										c.clear();
										c.println("Congratulations!! Welcome to the "+team[5]+". Your annual salary is $"+pay[5]+" million!");
										Thread.sleep(5000);
										c.println();
										c.println("This is the end of your story, you are playing for the "+team[5]+" as a substitute Point Guard who makes $"+pay[5]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
										playAgain = c.readLine();

									} else if (wolfChoice.equalsIgnoreCase("warrior")) {
										c.clear();
										c.println("Congratulations!! Welcome to the "+team[4]+". Your annual salary is "+pay[4]+" million!");
										Thread.sleep(5000);
										c.println();
										c.println("This is the end of your story, you are playing for the "+team[4]+" as a substitute Point Guard who makes $"+pay[5]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
										playAgain = c.readLine();

									}

								}
								//trade decline
								else if (knicksTrade.equalsIgnoreCase("no")){

									c.clear();
									c.println("Congratulations!! Welcome to the "+team [3]+". Your annual salary is $"+pay[3]+" million!");
									Thread.sleep(5000);
									c.println();
									c.println("This is the end of your story, you are playing for the "+team[3]+" as a starting Point Guard who makes $"+pay[3]+" mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
									playAgain = c.readLine();
								}

							}
						}
						//dont follow play
						else if (followPlay.equalsIgnoreCase("no")){
							c.clear();
							c.println("You lose the game. Ah well...\n\nWhile walking out of your change room you see a knife. \nDo you decide to pick it up? (type 'yes' or 'no' ");
							
						}
					}


				}
			} while (playAgain.equals("yes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
