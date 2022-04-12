public class AltString {
    private char[] string;

    public AltString(char[] arr) {
        this.string = arr;
    }

    public char[] getArray() {
        return string;
    }

    public int length() {
        return string.length;
    }

    public boolean isEmpty() {
        return string.length == 0 ? true : false;
    }

    public int indexOf(char c) {
        for (int i = 0; i < string.length; i++) {
            if (string[i] == c) {
                return i;
            }
        }

        return -1;
    }

    // вставляем символ спереди или сзади
    public void append(char c, boolean toStart) {
        char[] str = new char[this.length()+1];

        if (toStart) {
            str[0] = c;
            for (int i = 0; i < string.length; i++) {
                str[i+1] = string[i];
            }
        } else {
            for (int i = 0; i < string.length; i++) {
                str[i] = string[i];
            }
            str[str.length-1] = c;
        }

        string = str;
    }

    public AltString substring(int start, int end) {
        char[] str = new char[end-start+1];

        for (int i = start; i < end; i++) {
            str[i-start] = string[i];
        }

        return new AltString(str);
    }

    // резервирование места под символы
    public void reserve(int count) {
        char[] str = new char[this.length()+count];

        for (int i = 0; i < string.length; i++) {
            str[i] = string[i];
        }

        string = str;
    }
}

