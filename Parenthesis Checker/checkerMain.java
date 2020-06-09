import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
/*Data Structure Lecture, Assignment 1 : Parenthesis Checker
 * Firstly read the input files. Every opening parenthesis 
 * while reading this file is pushed into the stack with "push" operation. 
 * If each closing parenthesis matches the opening parenthesis when reading the file,
 * remove the pop-up operation from the stack with "pop". 
 * For this reason, the "checkValid" function was used to track and match these matches. 
 * When all matches are correct, we show the operations as output. 
 * If the matches are incorrect, we will output the corresponding error message. 
 * The "match" function was used to check whether the matches were correct or not.
 * @author Ahsen Amil
 * 
 * @Date : Nov 21, 2019
 * 
 */
public class checkerMain {

	public static void main(String[] args) throws IOException {

		File file = new File("input.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));  //read the input file
		String line = reader.readLine();                                   //read every line

		while (line!=null) {
			//System.out.println(line);
			line = reader.readLine();
		}
		if(checkValid("input.txt")) 
			System.out.println(checkValid(line)); 
		else 
			System.out.println("Parentheses don't match");
	}

	public static Boolean checkValid(String str){
		char parant=0,prev=0;
		Stack<Character> myStack = new Stack<>();
		for(int i=0; i<str.length(); i++){
			if(parant == '(' || parant=='{'){                              //check parenthesis type
				myStack.push(parant);                                      //now stack have parenthesis
				System.out.println(parant);                                //parenthesis will seen on output
			}
			if(parant == ')' || parant=='}'){                              //closed parenthesis won't be in stack
				if(myStack.isEmpty()){
					return false;
				}
				else{
					prev = (char) myStack.pop();                           //opening parenthesis pop thanks to closed paranthesis
					if(match(prev,parant))
						return false;
				}               
			}
		}
		if(myStack.isEmpty())                                              //now stack is empty after that for loop
			return true;
		return false;       
	}   
	public static boolean match(char parant1, char parant2){               //check parenthesis are match
		if(parant1 == '(' && parant2 == ')')                               // "(" must match ")"
			return true;
		else if(parant1 == '{' && parant2 == '}')                          // "{" must match "}"
			return true;
		else
			return false;
	}
}



