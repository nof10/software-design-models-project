rm -rf bin && mkdir -p bin && javac -cp AbsoluteLayout.jar -d bin src/Calc/\*.java

java -cp bin:AbsoluteLayout.jar Calc.App
