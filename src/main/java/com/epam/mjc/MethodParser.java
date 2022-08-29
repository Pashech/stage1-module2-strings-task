package com.epam.mjc;

import java.util.*;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        signatureString = "private int sum(int x, String str, double d)";
        StringTokenizer st = new StringTokenizer(signatureString, " ");
        String[] str = signatureString.split("\\(");
        String[] modif = str[0].split(" ");
        String accessModifier = null;
        String returnType = null;
        String methodName = null;

        if(modif.length == 3){
            accessModifier = modif[0];
            returnType = modif[1];
            methodName = modif[2];
        }else if (modif.length == 2){
            accessModifier = null;
            returnType = modif[0];
            methodName = modif[1];
        }

        StringTokenizer token = new StringTokenizer(signatureString, "()");
        List<String> parameters = new ArrayList<>();
        while(token.hasMoreTokens()){
            parameters.add(token.nextToken());
        }
        parameters.remove(0);
        String[] s = parameters.get(0).split(",");
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < s.length; i++){
            String[] par = s[i].split(" ");
            if(i == 0){
                map.put(par[0], par[1]);
            }else{
                map.put(par[1], par[2]);
            }
        }
        List<MethodSignature.Argument> argumentList = new ArrayList<>();


        return new MethodSignature(
                null
        );
    }
}
