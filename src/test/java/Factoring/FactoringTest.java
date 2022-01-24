package Factoring;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FactoringTest {

    @Test
    @DisplayName("first line other values than numbers")
    void firstLine_inputOtherValuesThanNumbers() {
        //given
        InputFactoring factoring = new InputFactoring();
        String input = this.randomInt()+" "+ this.generateString();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line other values than two numbers ")
    void firstLine_inputOtherValuesThanNumberTwo() {
        //given
        InputFactoring factoring = new InputFactoring();
        String input = this.randomInt()+" "+ this.randomInt()+this.generateString();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line more than 2 numbers")
    void firstLine_inputMoreThan2Numbers() {
        //given
        InputFactoring factoring = new InputFactoring();
        String input = this.randomInt()+" "+this.randomInt()+" "+this.randomInt();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line negative numbers")
    void firstLine_inputNegativeNumbers() {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = "-"+String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first input with correct values")
    void firstLine_correctInput() {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("Correct");
    }
    @Test
    @DisplayName("second input with negative numbers")
    void secondLine_inputWithNegativeNumbers () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne-1;i++) {
            input2.add(this.randomInt()+" "+this.randomInt());
        }
        input2.add(this.randomInt()+" "+(-(this.randomInt())));
        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("second line incorrect format of input")
    void secondLine_inputIncorrectFormatOfInput() {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne + 1;
        String input = String.valueOf(numberOne + 1) + " " + String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne-1;i++) {
            input2.add(this.randomInt()+" "+this.randomInt());
        }
        input2.add(this.randomInt()+" "+generateString());
        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("second input with correct values")
    void secondLine_inputWithCorrectValues () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("Correct");
    }
    @Test
    @DisplayName("third input with incorrect values - string")
    void thirdLine_inputWithIncorrectValues_String () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne + " "+generateString();

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("third input with incorrect values - negative numbers")
    void thirdLine_inputWithIncorrectValues_NegativeNumbers () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne + " "+(-numberOne);

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("third input with incorrect values - only one number")
    void thirdLine_inputWithIncorrectValues_OnlyOneNumber () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = String.valueOf(numberOne);

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("third input with incorrect values - more than 2 numbers")
    void thirdLine_inputWithIncorrectValues_moreThanTwoNumbers () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne+" "+numberOne+" "+numberOne;

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("third input with incorrect values - start value out of range")
    void thirdLine_inputWithIncorrectValues_startValueOutOfRange () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne+1+" "+numberOne;

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("range");
    }
    @Test
    @DisplayName("third input with incorrect values - end value out of range")
    void thirdLine_inputWithIncorrectValues_endValueOutOfRange () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne+" "+numberOne+1;

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("range");
    }
    @Test
    @DisplayName("third input with correct values")
    void thirdLine_inputWithCorrectValues () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne+" "+ (numberOne-1);

        //when
        var exception = factoring.thirdLine(input3);
        //than
        assertThat(exception).contains("Correct");
    }
    @Test
    @DisplayName("find distance without connection between start and end")
    void findDistanceWithoutConnection () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        input2.add((numberOne+2)+" "+(numberOne+3));
        for(int i=1; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = numberOne+" "+ (numberOne+3);
        factoring.thirdLine(input3);
        factoring.getLookingForNumber();
        //when
        var exception = factoring.getDistance();
        //than
        assertThat(exception).isEqualTo(-1);
    }
    @Test
    @DisplayName("find distance with connection between start and end")
    void findDistanceWithConnection () {
        //given
        InputFactoring factoring = new InputFactoring();
        Integer numberOne = this.randomInt();
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        List<String> input2=new ArrayList<>();
        for(int i=0; i<numberOne;i++) {
            input2.add((Integer.valueOf(numberOne)-i)+" "+numberOne);
        }
        factoring.secondLine(input2);
        String input3 = (numberOne-numberOne+1)+" "+ numberOne;
        factoring.thirdLine(input3);
        factoring.getLookingForNumber();
        //when
        var exception = factoring.getDistance();
        //than
        assertThat(exception).isGreaterThan(0);
    }

    public String generateString () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public Integer randomInt () {
        return (int)(Math.random() * 1000) + 1;
    }

}