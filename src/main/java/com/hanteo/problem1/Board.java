package com.hanteo.problem1;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Integer, Category> categories = new HashMap<>();

    public Category getCategoryById(int categoryId) {
        return categories.get(categoryId);
    }

    public Category getCategoryByName(String name) {
        for (Map.Entry<Integer, Category> entry : categories.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void addCategory(int categoryId, String name, int parentId) {
        Category category = findCategory(categoryId, name);

        if (parentId != -1) {
            Category parentCategory = getCategoryById(parentId);

            if (parentCategory != null) {
                parentCategory.addChild(category);
            }
        }

        categories.put(categoryId, category);
    }

    private Category findCategory(int categoryId, String name) {
        return getCategoryById(categoryId) != null ? getCategoryById(categoryId) : new Category(categoryId, name);
    }

    /**
     * object to json
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(categories);
    }

    public String toJson(Category category) {
        Gson gson = new Gson();
        return gson.toJson(category);
    }

    public static void main(String[] args) {
        Board board1 = new Board();
        Board board2 = new Board();

        board1.addCategory(0, "남자", -1);
        board1.addCategory(1, "엑소", 0);
        board1.addCategory(2, "BTS", 0);
        board1.addCategory(3, "공지사항", 1);
        board1.addCategory(4, "첸", 1);
        board1.addCategory(5, "백현", 1);
        board1.addCategory(6, "시우민", 1);
        board1.addCategory(7, "공지사항", 2);
        board1.addCategory(8, "익명게시판", 2);
        board1.addCategory(9, "뷔", 2);

        board2.addCategory(0, "여자", -1);
        board2.addCategory(1, "블랙핑크", 0);
        board2.addCategory(2, "공지사항", 1);
        board2.addCategory(3, "익명게시판", 1);
        board2.addCategory(4, "로제", 1);
        board2.addCategory(5, "트와이스", 0);
        board2.addCategory(6, "공지사항", 5);
        board2.addCategory(3, "익명게시판", 5);
        board2.addCategory(7, "모모", 5);

        System.out.println(board1.toJson());
        System.out.println(board2.toJson());

        Category findCategoryById = board1.getCategoryById(1);
        System.out.println(board1.toJson(findCategoryById));

        Category findCategoryByName = board1.getCategoryByName("BTS");
        System.out.println(board1.toJson(findCategoryByName));


        Category findCategoryById2 = board2.getCategoryById(1);
        System.out.println(board2.toJson(findCategoryById2));

        Category findCategoryByName2 = board2.getCategoryByName("트와이스");
        System.out.println(board2.toJson(findCategoryByName2));

        System.out.println(findCategoryById2.getChildren().get(1).equals(findCategoryByName2.getChildren().get(1)));
        System.out.println(findCategoryById2.getChildren().get(1).getName());
        System.out.println(findCategoryByName2.getChildren().get(1).getName());
    }
}
