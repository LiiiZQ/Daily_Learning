package com.tianmaying.snake;

import java.util.LinkedList;

public class Snake {

    private final LinkedList<Node> body = new LinkedList<>();

    public Node eat(Node food) {

        if (!isNeighbor(body.getFirst(), food)) {
            return null;
        }

        body.addFirst(food);
        return food;
    }

    /**
     * 往某个方向移动，蛇的身体可能会重叠，重叠判断由<code>Grid</code>处理。
     *
     * @param direction
     * @return <code>Snake</code>原来的尾部，即最后一个<code>SquareArea</code>
     */
    public Node move(Direction direction) {
        int x = body.getFirst().getX();
        int y = body.getFirst().getY();

        switch (direction) {
            case UP:
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
        }

        body.addFirst(new Node(x, y));
        return body.removeLast();
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
}
