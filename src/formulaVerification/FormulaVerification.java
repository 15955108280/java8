package formulaVerification;

import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/11/25 15:19
 */
public class FormulaVerification {
    static String formula[] = {"Sum", "Sumif", "Max", "Min", "Average", "sqrt", "exp", "power", "log", "ln", "log10"};
    static String logicalSymbol[] = {"=", "!=", ">", "<", "null", "notnull"};

    public static void main(String args[]) throws Exception {
//        String str1 = "(a-bc)+c-Max(Average(d,c))";
//        System.out.println(validateFormula(str1));

		String str1="(${a}=${1}or(${a}=${2}))";
		System.out.println(validateExpression(str1));

    }

    public static boolean validateFormula(String expression) {
        // 错误情况，(后面是运算符
        if (expression.matches(".*\\((\\+|-|\\*|\\/).*")) {
            return false;
        }

        // 错误情况，)前面是运算符
        if (expression.matches(".*(\\+|-|\\*|\\/)\\).*")) {
            return false;
        }


        if (!checkBrackets(expression)) {
            return false;
        }
        // 删除函数
        List<String> funcList = Arrays.asList(formula);
        for (String fun : funcList) {
            if (expression.contains(fun)) {
                expression = expression.replace(fun, "");
            }
        }
        System.out.println("去函数" + expression);


        // 去函数后判断(前面是否有字母
        if (expression.matches(".*\\w+\\(.*")) {
            return false;
        }


        // 问号替换
        expression = expression.replaceAll("\\w+", "?");

        System.out.println("替换问号" + expression);

        // 删除括号
        expression = expression.replace("(", "");
        expression = expression.replace(")", "");
        System.out.println("去括号" + expression);


        if (!expression.matches("^\\?((\\+|-|\\*|\\/|,)\\?)*$")) {
            return false;
        }

        return true;
    }

    public static boolean validateExpression(String expression) {
        // 判断左右括号
        if (!checkBrackets(expression)) {
            return false;
        }
        //错误情况以and或or结尾
        if(expression.matches(".*(and|or)$|^(and|or).*")){
            return false;
        }
        // 将逻辑符号替换为*
        List<String> funcList = Arrays.asList(logicalSymbol);
        for (String fun : funcList) {
            if (expression.contains(fun)) {
                expression = expression.replace(fun, "*");
            }
        }

        // 错误情况，(后面是逻辑符
        if (expression.matches(".*\\((\\*|and|or)\\).*")) {
            return false;
        }

        // 错误情况，)前面是逻辑符
        if (expression.matches(".*(\\*|and|or)\\).*")) {
            return false;
        }

		// 删除括号
		expression = expression.replace("(", "");
		expression = expression.replace(")", "");

        expression = expression.replaceAll("\\$\\{\\w+\\}", "?");

        String[] element = expression.split("and|or");
		for (String s : element) {
			if (!s.matches("^\\?(\\*\\?)*$")) {
				return false;
			}
		}

        return true;
    }

    public static boolean checkBrackets(String expression) {
        int num = 0;
        char[] expChars = expression.toCharArray();
        for (int i = 0; i < expChars.length; i++) {
            char temp = expChars[i];
            if (temp == '(') {
                num++;
            } else if (temp == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        if (num > 0) {
            return false;
        }
        return true;
    }

}
