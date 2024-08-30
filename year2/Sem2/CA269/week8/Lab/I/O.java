
// writing and reading files from java.io
// manipulation of files from java.nio.file
// to read and write we use the writer or reader objects

// filewriter is basic - writes to file
// explicityly writing new lines, closing the file etc
try {
	FileWriter out = new FileWriter(new File("test.txt"));
	out.write("test1\n");
	out.close()
}	catch(Exception E){

}

// can also use printWriter so we dont see the errors 
PrintWriter out = new PrintWriter("test.txt");
out.println("test2");
out.close()

// to read or write a file efficiently we use BUfferedReader and BufferedWriter
// handles multiple bytes rather than one 
// tokenizer function parse certain parts of input
// scanner method simialr but used to get just an int or boolean
BufferedReader in = new BufferedReader(new FileReader("input.txt"));
BufferedReader out = new BufferedWriter(new FileReader("output.txt"));

String line = in.readLine();
StringTokenizer tokenize = new StringTokenizer(line);
int x = Integer.parseInt(tokenize.nextToken());


// CSV FILES
// csv are files where data is broken using a comma , although tabs can also be used
// we can use the scanner object
Scanner input = new Scanner(new File("test.csv"));
input.useDelimiter(",");
while (input.hasNext()){
	String token = input.next();
	// do something with data
}
input.close()
// the above code will give each csv token at a time with no distinction between rows

// to take inputs one row at a time we can use nextLine()
Scanner input = new Scanner(new File("data.txt"))
input.useDelimiter(",")
while(input.hasNextLine()){
	String[] data = input.nextLine().split(",");
	for (String item: data){
		System.out.print(item + " ");
	}
	System.out.println();
}
input.close()

// output
// id name comment
// 1 john misc
// 2 jane misc

// in most cases, the first line will include headers for the data which should be ignored
// we can use nextLine() for the first line, then iterate the rest after
