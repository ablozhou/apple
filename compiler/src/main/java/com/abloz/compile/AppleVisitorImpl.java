package com.abloz.compile;

import com.abloz.antlr.AppleBaseVisitor;
import com.abloz.antlr.AppleParser;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *@author Andy Zhou <ablozhou@gmail.com>
 *@date 2019.08.15
 */
public class AppleVisitorImpl extends AppleBaseVisitor<Integer> {

    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<String, Integer>();


    @Override
    public Integer visitParens(AppleParser.ParensContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public Integer visitNewLine(AppleParser.NewLineContext ctx) {
        return 0;
    }

    /**
     *  expr op=('*'|'/') expr
     * @param ctx
     * @return
     */
    @Override
    public Integer visitMulDiv(AppleParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));  // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == AppleParser.MUL ) return left * right;
        return left / right; // must be DIV

    }

    @Override
    public Integer visitExpress(AppleParser.ExpressContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.printf("%d\n",value);
        return value;
    }

    @Override
    public Integer visitProg(AppleParser.ProgContext ctx) {
        Integer c = ctx.getChildCount();
        Integer value = 0;
        for(Integer i = 0; i < c; i++){
            value = visit(ctx.getChild(i));

        }
        return value;
    }

    @Override
    public Integer visitAssign(AppleParser.AssignContext ctx) {
        String id= ctx.ID().getText();
        Integer value = visit(ctx.expr());
        memory.put(id,value);
        return value;
    }

    @Override
    public Integer visitAddSub(AppleParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if(ctx.op.getType() == AppleParser.ADD) {
            return left + right;
        }

        return left-right;
    }

    @Override
    public Integer visitId(AppleParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        //System.out.println("id:"+id);

        return 0;
    }

    @Override
    public Integer visitInt(AppleParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
}