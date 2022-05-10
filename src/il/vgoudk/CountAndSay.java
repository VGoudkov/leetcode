package il.vgoudk;

import jdk.jshell.SourceCodeAnalysis;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

    final char NO_LETTER = (char) 0;

    public String countAndSay(int n) {
        return say( "1", n, 1);
    }

    private String say(String sentence, int maxLevel, int curLevel) {
        if( curLevel == maxLevel) return sentence;
        final List<GroupElement> groupElements = countGroups(sentence);
        final String newSentence = pronounce(groupElements);
        final String say = say(newSentence, maxLevel, curLevel + 1);
        return say;
    }

    String pronounce(List<GroupElement> groupElements) {
        StringBuilder sb = new StringBuilder();
        for (GroupElement g : groupElements) {
            if( g.letter == NO_LETTER) continue;
            sb.append(g.count).append(g.letter);
        }
        return sb.toString();
    }


    List<GroupElement> countGroups(String input) {
        List<GroupElement> ret = new ArrayList<>(input.length());
        char[] letters = input.toCharArray();
        char curLetter = NO_LETTER;
        GroupElement groupElement = new GroupElement(NO_LETTER);
        for (int i = 0; i < input.length(); i++) {
            if (letters[i] != curLetter) {
                curLetter = letters[i];
                groupElement = new GroupElement(curLetter);
                ret.add(groupElement);
            }
            groupElement.count++;
        }
        return ret;
    }


    class GroupElement {
        char letter;
        int count;

        public GroupElement(char letter) {
            this.letter = letter;
            count = 0;
        }
    }

}