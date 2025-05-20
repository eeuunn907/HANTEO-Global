package org.example;

import org.example.domain.Category;
import org.example.domain.CategoryTree;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        CategoryTree tree = new CategoryTree();

        // 예시 데이터 삽입 (id, name, boardId, parentId)
        tree.addCategory(1, "남자", null, null);
        tree.addCategory(2, "엑소", null, 1);
        tree.addCategory(3, "공지사항", 1, 2);
        tree.addCategory(4, "첸", 2, 2);
        tree.addCategory(5, "백현", 3, 2);
        tree.addCategory(6, "시우민", 4, 2);
        tree.addCategory(7, "방탄소년단", null, 1);
        tree.addCategory(8, "공지사항", 5, 7);
        tree.addCategory(9, "익명게시판", 6, 7);
        tree.addCategory(10, "뷔", 7, 7);
        tree.addCategory(11, "여자", null, null);
        tree.addCategory(12, "블랙핑크", null, 11);
        tree.addCategory(13, "공지사항", 8, 12);
        tree.addCategory(14, "익명게시판", 6, 12);
        tree.addCategory(15, "로제", 9, 12);

        // JSON 출력
        System.out.println(tree.toJson());

        // 특정 이름 검색
        List<Category> announcements = tree.getCategoriesByName("공지사항");
        for (Category c : announcements) {
            System.out.println("ID: " + c.getId() + ", BoardID: " + c.getBoardId());
        }
    }
}