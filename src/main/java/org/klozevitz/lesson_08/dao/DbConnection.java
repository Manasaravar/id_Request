package org.klozevitz.lesson_08.dao;

import org.klozevitz.lesson_08.model.Notepad;

import java.util.List;

public interface DbConnection {
    List<Notepad> all();
    void close();
    Notepad idRequest(Integer id);
}
