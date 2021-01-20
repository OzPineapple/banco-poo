d:
	rm -f *.class
	javac *.java
	java Banco

b:
	rm -f *.class
	javac *.java -g && jdb Banco