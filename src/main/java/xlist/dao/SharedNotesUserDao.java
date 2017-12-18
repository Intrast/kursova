package xlist.dao;

import xlist.models.User;

import java.util.List;

/**
 * Інтерфесйс, що містить методи для роботи із таблицею sharednotesusers
 */
public interface SharedNotesUserDao {
    /**
     * Повернути користувачів що розшарюють заміку
     * @param id замітки
     * @return колекція із користувачів, що призначені до замітки яка має значення id
     */
    List<User> getUsersByNoteId(long id);
}
