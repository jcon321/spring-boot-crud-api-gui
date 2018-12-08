package com.jconner.demo.view;

import com.jconner.demo.controller.NoteController;
import com.jconner.demo.model.Note;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope(value = "session")
@Component(value = "noteListsPageBean")
@ELBeanName(value = "noteListsPageBean")
@Join(path = "/", to = "/note-lists.jsf")
public class NoteListsPageBean {

    @Autowired
    NoteController noteController;

    private List<Note> notes;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        notes = noteController.getAllNotes();
    }

    public List<Note> getNotes() {
        return notes;
    }
}
