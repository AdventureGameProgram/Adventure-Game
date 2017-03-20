package addo.alKwiliy.abdulle;
/**
 * AdventureGame
 * Choose your own adventure game related to basketball.
 * 20/03/17
 * @author Ahmed Addo, Fayez Al-kwiliy, Ayub Abdulle
 */

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import hsa_new.Console;

public class AdventureGame {

	public static void main(String[] args) {
		String playAgain = "";
		BufferedImage courtImage = null;
		BufferedImage draftImage = null;
		BufferedImage crowdImage = null;
		BufferedImage missedShotImage = null;
		BufferedImage knifeImage = null;
		BufferedImage guyFightImage = null;
		try {
			Console c = new Console();

			do {
				c.clear();
				// images
				courtImage = ImageIO.read(new File("I-Stock-Basketball-Court.jpg"));
				draftImage = ImageIO.read(new File("nba-nba-draft-1.jpg"));
				crowdImage = ImageIO.read(new File("crowd yay.jpg"));
				missedShotImage = ImageIO.read(new File("MissedShot.jpg"));
				knifeImage = ImageIO.read(new File("knifeImage.jpg"));
				guyFightImage = ImageIO.read(new File("guy fight.jpg"));
				// Introduction to game
				c.drawImage(courtImage, 0, 0, c.getWidth(), c.getHeight(), null);
				c.println(
						"This is a story about your career, the choices you make will change the outcome of your life... \nYou are a college basketball player, you're playing a championship game and there's 10 seconds left and your team is down 2, and the coach has decided your taking the final shot. There are many scouts at the game watching your every move. What do you do? (If you want to take a three pointer to win type in 'shot', if you want to tie the game with a layup and go into overtime type in 'layup')");
				// Major Variables
				int random;
				// NBA Pays, and Teams
				String[] team = { "Philadelphia 76ers", "Los Angeles Lakers", "Cleveland Cavaliers", "New York Knicks",
						"Golden State Warriors,", "Minnesota Timberwolves" };
				int[] pay = { 10, 11, 9, 7, 5, 8 };
				// sound making
				Clip crowdCheer = AudioSystem.getClip();

				// create the clip object
				crowdCheer.open(AudioSystem.getAudioInputStream(new File("NBA_game_crowd_sound_effect_-_normal.wav")));

				// Primary decision
				String finalShot = c.readLine();
				// take shot routes and variables
				String philTrade;
				String lakersChoice;
				// lay up route variables
				String stayOnTeam;
				String followPlay;
				String careerDecision;
				String knicksTrade;
				String wolfChoice;
				String fightChoice;
				boolean hasKnife = false;
				String pickUpKnife;
				String teammateReport;
				String useKnife;
				// shot decision
				if (finalShot.equalsIgnoreCase("Shot")) {
					// random number for chance of hitting shot
					random = (int) (Math.random() * 4 + 1);
					// if the shot hits
					if (random == 4) {
						c.clear();
						c.drawImage(crowdImage, 0, 0, c.getWidth(), c.getHeight(), null);
						c.println("YOU HIT THE SHOT!");
						crowdCheer.start();
						Thread.sleep(5000);
						c.clear();
						c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
						c.println(
								"Scouts were impressed by your performance! \n\n You were drafted as the 1st pick in the 2017 draft to the "
										+ team[0] + ". Your income is $" + pay[0]
										+ " would you like to trade to a different team?");
						c.println();
						c.println(
								"(Type in 'yes' if you would like to trade or type in 'no' if you would not like to trade)");
						c.println();
						philTrade = c.readLine();
						c.clear();
						// team trades
						c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
						if (philTrade.equalsIgnoreCase("Yes")) {
							c.println("Both the " + team[2] + " and the " + team[1]
									+ " are willing to take you.\n\nThe  are " + team[2] + " are offering $" + pay[2]
									+ " mill/a and the " + team[1] + " are offering $" + pay[1]
									+ " mill/a. \n(Type 'cavs' if you select " + team[2]
									+ " or type in 'lakers' for the " + team[1] + ")");

							c.println();
							lakersChoice = c.readLine();
							if (lakersChoice.equalsIgnoreCase("Lakers")) {
								c.clear();
								c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
								c.println("Congratulations!! Welcome to the " + team[1] + ". Your annual salary is $"
										+ pay[1] + " million!");
								Thread.sleep(5000);
								c.println();
								c.println("This is the end of your story, you are playing for the " + team[1]
										+ " as a substitute Point Guard who makes $" + pay[1]
										+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
								playAgain = c.readLine();

							} else if (lakersChoice.equalsIgnoreCase("Cavs")) {
								c.clear();
								c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
								c.println("Congratulations!! Welcome to the " + team[2] + ". Your annual salary is "
										+ pay[2] + " million!");
								Thread.sleep(5000);
								c.println();
								c.println("This is the end of your story, you are playing for the " + team[2]
										+ " as a substitute Point Guard who makes $" + pay[2]
										+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
								playAgain = c.readLine();

							}

						}
						// trade decline
						else if (philTrade.equalsIgnoreCase("no")) {
							c.clear();
							c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
							c.println("Congratulations!! Welcome to the " + team[0] + ". Your annual salary is $"
									+ pay[0] + " million!");
							Thread.sleep(5000);
							c.println();
							c.println("This is the end of your story, you are playing for the " + team[0]
									+ " as a starting Point Guard who makes $" + pay[0]
									+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
							playAgain = c.readLine();
						}
					}
					// shot doesn't hit
					else {
						c.clear();
						c.drawImage(missedShotImage, 0, 0, c.getWidth(), c.getHeight(), null);
						c.println("You missed and cost your team the game.");
						Thread.sleep(5000);
						c.clear();
						c.println(
								"This is the end of your story, You don't make it into the NBA this year but you still play for your college team. There's always next year! \n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no') ");
						playAgain = c.readLine();
					}
				}
				// layup decision
				else if (finalShot.equalsIgnoreCase("layup")) {
					random = (int) (Math.random() * 4 + 1);
					// if layup fails
					if (random == 4) {
						c.clear();
						c.println(
								"While going for the layup, you get fouled and have to take free throws.\n\nYou ended up missing both shots and everyone boo's you.");
						Thread.sleep(5000);
						c.clear();
						c.println(
								"After the game your coach decides to kick you from the team. Do you accept getting kicked out or beg your coach to let you stay\n(Type in 'beg' to beg your coach or type in 'accept' to accept getting kicked");
						stayOnTeam = c.readLine();
						if (stayOnTeam.equalsIgnoreCase("beg")) {
							c.clear();
							c.println(
									"You get laughed at and are humiliated in front of everyone. Guess you're not on the team anymore.\n\nYou decide to apply for another college who will actually respect your skill.\n\nYou've been accepted into this college. They had a way better team anyway. Good luck at tryouts!!");
							Thread.sleep(10000);
							c.clear();
							c.println(
									"This is the end of your story, You've applied for another college team and have made it!\n You're not a starter, but if you keep up the good work you will be there in no time!\n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no') ");
							playAgain = c.readLine();

						} else if (stayOnTeam.equalsIgnoreCase("accept")) {
							c.clear();
							c.println(
									"No more college basketball for you now, maybe you're more suited for another career.\nBetter get those grades up.");
							c.println();
							c.println(
									"This is the end of your story. You end up working at McDonalds for minimum wage. Told you to get those grades up!\n\nWould you like to play again and change the outcome of that game? (Type 'yes' or 'no' ");
							playAgain = c.readLine();

						}
					}
					// if layup goes in
					else {
						c.clear();
						c.println("You tied the game and are going into overtime.");
						crowdCheer.start();
						Thread.sleep(5000);
						c.clear();
						c.println(
								"In overtime you get subbed off for the first several minutes. \nYou are put in for the final minutes of the game. Your coach gives you a play, but you doubt it'll work.\nDo you follow it? (type in 'yes' or 'no')");
						followPlay = c.readLine();
						// follow the play
						if (followPlay.equalsIgnoreCase("yes")) {
							random = (int) (Math.random() * 4 + 1);
							// chances of play failing
							if (random == 4) {
								c.clear();
								c.println("You guys lose. Ah well you tried your best right?");
								Thread.sleep(5000);
								c.clear();
								c.println(
										"Time passes and you graduate from college. You've spent a lot of your time in school studying social sciences, but are very qualified to be a basketball coach. \nDo you wish to become a high school basketball coach or a behaviour management worker?\n(Type 'basketball' to become a coach or type 'management' to become a behaviour management worker)");
								careerDecision = c.readLine();
								if (careerDecision.equalsIgnoreCase("basketball")) {
									c.clear();
									c.println(
											"Congratulations, this is the end of your story. You chose to become a high school basketball coach, and have become really successful.\nYour annual salary is $75k/a \n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
									playAgain = c.readLine();
								} else if (careerDecision.equalsIgnoreCase("managment")) {
									c.clear();
									c.println(
											"Congratulations, this is the end of your story. You chose to become a behaviour managment worker who earns $65k/a \nHowever, after a year on the job one of your clients beat you up. You get hospitalized for a year, but you'll be fine!\n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
									playAgain = c.readLine();
								}

							}
							// the play works
							else {
								c.clear();
								c.println(
										"YOU GUYS WON!!! Your team and scouts are really impressed about your performance. You have quite a life coming ahead of you! ");
								crowdCheer.start();
								Thread.sleep(10000);
								c.clear();
								c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
								c.println("You were drafted as the 1st pick in the 2017 draft to the " + team[3]
										+ ". Your income is $" + pay[3]
										+ " mill/a would you like to trade to a different team?");
								c.println();
								c.println(
										"(Type in 'yes' if you would like to trade or type in 'no' if you would not like to trade)");
								c.println();
								knicksTrade = c.readLine();
								c.clear();
								c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
								// team trading
								if (knicksTrade.equalsIgnoreCase("Yes")) {
									c.println("Both the " + team[5] + " and the " + team[4]
											+ " are willing to take you.\n\nThe  are " + team[5] + " are offering $"
											+ pay[5] + " mill/a and the " + team[4] + " are offering $" + pay[4]
											+ " mill/a. \n(Type 'warrior' if you select " + team[4]
											+ " or type in 'wolf' for the " + team[5] + ")");
									c.println();
									wolfChoice = c.readLine();
									if (wolfChoice.equalsIgnoreCase("wolf")) {
										c.clear();
										c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
										c.println("Congratulations!! Welcome to the " + team[5]
												+ ". Your annual salary is $" + pay[5] + " million!");
										Thread.sleep(5000);
										c.println();
										c.println("This is the end of your story, you are playing for the " + team[5]
												+ " as a substitute Point Guard who makes $" + pay[5]
												+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
										playAgain = c.readLine();

									} else if (wolfChoice.equalsIgnoreCase("warrior")) {
										c.clear();
										c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
										c.println("Congratulations!! Welcome to the " + team[4]
												+ ". Your annual salary is " + pay[4] + " million!");
										Thread.sleep(5000);
										c.println();
										c.println("This is the end of your story, you are playing for the " + team[4]
												+ " as a substitute Point Guard who makes $" + pay[4]
												+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
										playAgain = c.readLine();

									}

								}
								// trade decline
								else if (knicksTrade.equalsIgnoreCase("no")) {

									c.clear();
									c.drawImage(draftImage, 0, 0, c.getWidth(), c.getHeight(), null);
									c.println("Congratulations!! Welcome to the " + team[3]
											+ ". Your annual salary is $" + pay[3] + " million!");
									Thread.sleep(5000);
									c.println();
									c.println("This is the end of your story, you are playing for the " + team[3]
											+ " as a starting Point Guard who makes $" + pay[3]
											+ " mill/a \n\nWould you like to play again and have a different life? (Type 'yes' or 'no') ");
									playAgain = c.readLine();
								}

							}
						}
						// dont follow play
						else if (followPlay.equalsIgnoreCase("no")) {
							c.clear();
							// object pickup
							c.drawImage(knifeImage, 0, 0, c.getWidth(), c.getHeight(), null);
							c.println(
									"You lose the game. Ah well...\n\nWhile walking out of your change room you see a knife. \nDo you decide to pick it up? (type 'yes' or 'no')");
							pickUpKnife = c.readLine();
							if (pickUpKnife.equalsIgnoreCase("yes")) {
								hasKnife = true;
							} else if (pickUpKnife.equalsIgnoreCase("no")) {
								hasKnife = false;
							}
							c.clear();
							c.drawImage(guyFightImage, 0, 0, c.getWidth(), c.getHeight(), null);
							c.println(
									"On your way to your dorm, one of your teammates starts get on your case for losing the game. \nDo you choose to fight him?(type 'fight' or 'walk') ");
							// choose to fight or walk
							fightChoice = c.readLine();
							// they choose to fight
							if (fightChoice.equalsIgnoreCase("fight")) {
								c.clear();
								c.println(
										"You get crushed. Sucks to be you.. \nYou also get fined for initiating the fight and are sent to do 2 years of community service! \n Lesson learned, don't start fights.");
								c.println(
										"\n\nThis is the end of your story. You haven't done much with your basketball career, but you did learn some valuable lessons.\nYou're still in school so keep studying! \n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
								playAgain = c.readLine();
							} else if (fightChoice.equalsIgnoreCase("walk")) {
								// they choose to walk away
								c.clear();
								c.println(
										"His squads jumps you later on. Thankfully you get away safely. \n Do you tell your coach and get him kicked off or tell the police about the incident? \n (Type 'coach' or 'police')");
								teammateReport = c.readLine();
								if (teammateReport.equalsIgnoreCase("police")) {
									c.clear();
									c.println(
											"Rumor has it you're reporting the incident to the police. \nYour teammate's squad gangster friends are going to deal with. \nDo you have a knife to defend yourself? Or will you be killed?");
									useKnife = c.readLine();

									if (hasKnife == true) {
										// checks if user has knife
										// if they do go onto to this option
										if (useKnife.equalsIgnoreCase("yes")) {
											c.clear();
											c.println(
													"While defending yourself, you end up stabbing one of the gangsters.\nYou manage to run away before they kill you but now you're wanted due to nearby witnesses \n\nThe police end up catching you and you are jailed for 10 years.");
											Thread.sleep(10000);
											c.clear();
											c.println(
													"You can't attend college and no employers want you due to your criminal record.\n Only a miracle will change your life now.");
											c.println(
													"\n\nThis is the end of your story. You are unemployed and are homeless. Your life has gone to trash. \n\nWould you like to play again and change your life? (Type 'yes' or 'no')");
											playAgain = c.readLine();

										} else if (useKnife.equalsIgnoreCase("no")) {
											c.clear();
											c.println(
													"You didn`t use your knife, and had no choice but to accept your fate.\n You died..");
											c.println(
													"\n\nThis is the end of your story. You have died and that's pretty much it. \n\nWould you like to play again and change the outcome of your life? (Type 'yes' or 'no')");
											playAgain = c.readLine();

										}
									} else {
										// user doesn't have a knife so their
										// answer is invalid
										// only have the option of dying
										c.clear();
										c.println(
												"You didn`t have a knife to defend defend yourself, \n and had no choice but to accept your fate.\n You died..");
										c.println(
												"\n\nThis is the end of your story. You have died and that's pretty much it. \n\nWould you like to play again and change the outcome of your life? (Type 'yes' or 'no')");
										playAgain = c.readLine();
									}

								} else if (teammateReport.equalsIgnoreCase("coach")) {
									c.clear();
									c.println(
											"You decide to tell your coach and your teammate gets kicked out.\nYou're known as a loser for the rest of your college life\nand have gone into depression.\nThis depression affect the rest of your life and no matter how hard you try\nyou never get far in life.");
									c.println(
											"\n\nThis is the end of your story. You haven't graduated with your college diploma and have been seeing your weekly therapist now and then.\nJust keep trying and you'll get better soon. \n\nWould you like to play again and change the outcome of your life? (Type 'yes' or 'no')");
									playAgain = c.readLine();
								}
							}
						}
					}

				}
			} while (playAgain.equals("yes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
