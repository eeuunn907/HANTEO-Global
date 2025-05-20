package org.example.domain;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryTree {
    private Map<Integer, Category> categoryMap = new HashMap<>();     // id 기준으로 검색
    private Map<String, List<Category>> nameMap = new HashMap<>();    // 이름 기준으로 검색
    private List<Category> roots = new ArrayList<>();                 // 최상위 루트 카테고리들

    public void addCategory(int id, String name, Integer boardId, Integer parentId) {
        Category category = new Category(id, name, boardId);
        categoryMap.put(id, category);
        nameMap.computeIfAbsent(name, k -> new ArrayList<>()).add(category);

        if (parentId == null) {
            roots.add(category);
        } else {
            Category parent = categoryMap.get(parentId);
            if (parent != null) {
                parent.addChild(category);
            }
        }
    }

    public Category getCategoryById(int id) {
        return categoryMap.get(id);
    }

    public List<Category> getCategoriesByName(String name) {
        return nameMap.getOrDefault(name, Collections.emptyList());
    }

    public String toJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roots);
    }
}
