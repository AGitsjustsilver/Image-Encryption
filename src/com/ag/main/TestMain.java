package com.ag.main;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestMain /*extends Application*/{

	public static final String TEST_STRING = "Jean Louise Finch and Jeremiah Atticus Finch learn to handle how life is in To Kill a Mockingbird a novel by Harper Lee. In To Kill a Mockingbird both Jem and scout grow up in a racist community of the south and go through journeys that will prepare them for the future. When a trial flares up scout and Jem learn that life is not what it seemed to be when they were younger.  Both Jem and Scout learn positive and exemplary life lessons from people they look up to.\n" +
            "Atticus teaches Jem and Scout life lessons through his positive example. For example, when scout does not understand why Miss Caroline does not see the way Maycomb is Atticus tells Scout how she could “learn a simple trick” to “understand” some ones “point of view” to see how some other “folk” lead their lives (Lee30).Scout does not understand on how other people’s lives are afflicted by where they come from or how they live. When Atticus tells scout to change in a way so that she may learn a new way to deal with people from different backgrounds. Another example of Atticus’ positive life lesson is when Jem lost his cool over by Mrs. Dubose house and smashed all her camellias with Scout’s baton when he was trying to defend scout’s honor, he would know that will have to “keep his head” even in “far worse things” but sometimes you “have to make the best of things.”(Lee104)When Jem lost his control over someone being Mrs. Dubose offending Scout is childish to react so poorly on someone’s possessions over something that is only one sided. Jem did not make the most mature thing to do by destroying the camellias with Scouts baton that he also broke the camellias with. Both Jem and scout do not know what is possible in the world yet but Atticus tries to teach them positively. Jem and Scout learn about life through their experiences. As a result of segregation, Jem’s mind is being clouded about ethnicity in example mixed children are in “between” the segregation all alone because not “colored folk” or “white folk” are willing to accept them (Lee 161).Jem now knows that in this time people will be judged based on their skin color for what they do or will do. The fact that people are not accepted by other people of the same species is very frustrating and would be very hard to look past. In example Mr. Dolphus-Raymond is a white man that has married a colored woman and have had children, he disguises that with appearing to look drunk but all he does is drink Coca-Cola although “it is not honest” it gives people a wrong impression so that they “never understand” his secret lifestyle (Lee200-201).Although Mr. Dolphus-Raymond has broken the unspoken rule of the two ethnicities he knows he would be in trouble so he hides the fact by giving the look that he is too drunk to be making the right decisions according to the unspoken law. People think differently of Mr. Raymond because his choice of life, many others think his choices are bad but some people like to live differently from other types of lifestyles. Now that the children are growing up they are starting to notice that the world they live in is different that the way they thought it would be. Boo Radley teaches the children to be caring and selfless. For example Jem and Scout find items in the knot hole of the Radley’s tree and when Jem finds Indian pennies he decides he will “keep them” but when “school starts” he and Scout will “go around” to “ask” if they belong to anyone (Lee 35).When they find the lucky pennies Jem does not feel right if he just takes them for himself he wants to find the original owner of the pennies.The pennies are supposed to be good luck if you had them, Jem must of felt guilty for just have been given them without giving back to the person. Furthermore after the events of the attack from Bob Ewell, Scout has Arthur escort her “down the sidewalk”  to look like a “gentleman” so incase Stephanie Crawford saw from her “upstairs window” she would have to end the rumors(Lee 278).Scout is showing that the rumors about Arthur being a monster and other nasty things are wrong. Scout tries to display to the neighborhood how she does not think of all the bad things she and the people of maycomb have said about him in the past. Like secret messages Arthur Radley tries to tell the kids to be more selfless by giving them presents and saving their lives here and there.\n When you do not see how others understand certain things or lose control on your behavior towards some one that made you go beyond the point of snapping instead offer help to those that need to see the other point of view. Either it is a neighbor of a parent both will still try to make you see something important that is needed to change. Seeing that an innocent person try to defend themselves or someone shunned for the way they want to live can show that they are trying to change what the people have become. Today people try to change either how things can be run to make a difference or to change how people run or chose how to live their lives like. How will you change the way you live and how others will also chose.,,,,,\n";
	public static Color[][] pic;

	public TestMain(){

    }

	public static void main(String [] args){
//		launch(args);
		TestMain a = new TestMain();
		int[] bigNums = {8220,8221,8217,8218};
		for(int c : bigNums){
            int nonce = 0;
            System.out.print(c + " " + (char)(c));
            while( c > 255 && !(c+nonce < 256)){
                c -= 255;
                nonce++;
                /*if(c+nonce <255){
                    c += nonce;
                }*/
            }
            System.out.println(c + " " + (char)(c));
        }

//        a.algTest();
//        a.charList(TEST_STRING);
        System.out.println((char)(8220) + "    " + (char) (8221) + "    "  + (char)(8217)+ "    " +(char)(8218));
//        Crypt c = new Encrypt(TEST_STRING);
//		regExTest();
//		aspectTesting();

//        System.out.println("a has the hash code of " + Character.hashCode('a') + ".\n" + "a also has the hashcode of " + (int)'a' +". \n" + "but 97 is the character " + (char)97);
	}

	/*private GridPane g;

	public void start(Stage pStage){
		pStage.setTitle("Testing Class");
		g = new GridPane();



		Scene s = new Scene(g, 500, 500);
		pStage.setScene(s);
		pStage.show();
	}*/

    private void charList(String t){
        final int LIMIT = 20;
        int count = 0;
        String [] a = t.split(" ");
        for(String b : a){
            char[] c = b.toCharArray();
            for(char d : c){
                int hashVal = Character.hashCode(d);
                int intVal = Character.getNumericValue(d);
                System.out.printf("%d", hashVal);
                if(hashVal > 255){
                    System.out.print("- \n");
                }else{
                    System.out.println();
                }
            }
        }
    }

	public static void setAllTo(){
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
                pic[row][col] = Color.rgb(0,0,0,.25);
			}
		}
	}

	public static void aspectTesting(){
		// Scanner s = new Scanner(System.in);
		// boolean f = true;
		// while(f){
		// 	int in = s.nextInt();
		// 	if(in == -1){
		// 		f = false;
		// 	}else{
				// int[] test = {43, 35};
				int[] test = {TEST_STRING.length(), 32};
				for (int i : test) {
					int completeColors = (i/3)+2;
					int unPairedColors = i%3;
					// for a 4:3 aspect ratio
					double row = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
					double col = Math.floor((4/3.0) * row)+1;
					double totalPix = row*col;
					double emptyPix43 = totalPix - (completeColors+((unPairedColors%3!=0)? 1:0));
					System.out.println("Number of Characters\tTotal Pixels\tColumn Pixels\tRow Pixels\tEmpty Pixels");
					System.out.printf("%-23d %-15.0f %-15.0f %-11.0f %-15.0f\n", i, totalPix, col, row, emptyPix43);
				}
		// 	}
		// }
		// s.close();

			// int len = inMess.length();
			// int numOfColors = len / 3;
			// int numOfUnpaired = len % 3;
			// w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			// l = new Double(Math.floor((4/3.0) * w)+1);
	}

	public void algTest(){
		Random rand = new Random();
		int[] meta = new int[6];
		for(int l = 0; l < meta.length; l++){
			meta[l] = rand.nextInt(255)+1;
		}
		int g = TEST_STRING.length();
		int completeColors = (g/3)+2;
		int unPairedColors = g%3;
		// for a 4:3 aspect ratio
		Double r = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
		Double c = Math.floor((4/3.0) * r)+1;

		pic = new Color[r.intValue()][c.intValue()];
		setAllTo();
		String[] test1 = TEST_STRING.split(" ");
		pic[0][0] = Color.rgb(meta[0], meta[1], meta[2], .5);
		pic[0][1] = Color.rgb(meta[3], meta[4], meta[5], .5);
		int row = 0, col = 2;
        ArrayList<Integer> color = new ArrayList<>();
		for (String a : test1) {
            char[] t = a.toCharArray();
            for (char b : t) {
                //initializes the array of hash values to put into colors
                int hashVal = Character.hashCode(b);
                if(hashVal > 255){

                }
                color.add(hashVal);
                if(b == t[t.length-1]){
                    color.add(32);
                }
            }
            if ((a.equals(test1[test1.length-1])) && (color.size()%3 != 0)){
                while(color.size()%3 != 0){
                    color.add(32);
                }
            }
            while(color.size() >= 3){
                if(row != r.intValue()-1){
                    if (col != c.intValue()-1) {
                        // general cells - the inbetween
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col++;
                    }else{
                        //if it is the last column in the row
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col = 0;
                        row++;
                    }
                }else{
                    //if it is the last row
                    if (col != c.intValue()-1) {
                        //all cells before the last cell
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col++;
                    }else{
                        //the last cell
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                    }
                }
                for(int l = 2; l >= 0; l--){
                    color.remove(l);
                }
            }
		}
		String res = "";
		for (int r1 = 0;r1 < pic.length; r1++) {
			for (int c1 = 0;c1 < pic[r1].length; c1++) {
				if(pic[r1][c1] != null){
					if (c1 == pic[r1].length-1){
						res += pic[r1][c1].toString() + " \n";
					}else{
						res += pic[r1][c1].toString() + " ";
					}
				}else{
					if (c1 == pic[r1].length-1){
						res += "null \n";
					}else{
						res += "null ";
					}
				}
			}
		}
		System.out.println(res);
		String mess = "";
        for(Color[] a: pic){
            for(Color b: a){
                String colorString = b.toString().substring(2,8);
                String colorAffix = b.toString().substring(8);
                String[] split = {colorString.substring(0,2), colorString.substring(2,4), colorString.substring(4)};
                if(colorAffix.equals("ff")){
                    for(String d: split){
                        mess += hexToChar(d);
                    }
                }
            }
        }
        System.out.println(mess);
	}

	private char hexToChar(String g){
	    return (char) hexToInt(g);
    }

    private int hexToInt(String twoDigitHex){
        HashMap<Character, Integer> map = build();
        char c1 = twoDigitHex.charAt(0);
        char c2 = twoDigitHex.charAt(1);
        int sum = 0;
        for(Character a : map.keySet()){
            if (c1 == a){
                sum += map.get(a) * 16;
            }
            if(c2 == a){
                sum += map.get(a);
            }
        }
        return sum;
    }

    private HashMap<Character, Integer> build(){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(new Character('0'), new Integer(0));
        map.put(new Character('1'), new Integer(1));
        map.put(new Character('2'), new Integer(2));
        map.put(new Character('3'), new Integer(3));
        map.put(new Character('4'), new Integer(4));
        map.put(new Character('5'), new Integer(5));
        map.put(new Character('6'), new Integer(6));
        map.put(new Character('7'), new Integer(7));
        map.put(new Character('8'), new Integer(8));
        map.put(new Character('9'), new Integer(9));
        map.put(new Character('a'), new Integer(10));
        map.put(new Character('b'), new Integer(11));
        map.put(new Character('c'), new Integer(12));
        map.put(new Character('d'), new Integer(13));
        map.put(new Character('e'), new Integer(14));
        map.put(new Character('f'), new Integer(15));
        return map;
    }



    public static void regExTest(){
		String[] t = TEST_STRING.split(" ");
		for(String s: t){
			System.out.print(s);
		}
		System.out.println();
		StringBuilder b;
		for (int i  = 0; i < t.length; i++){
			 t[i].concat(" ");
		}
		for(String s: t){
			System.out.print(s);
		}
	}
}