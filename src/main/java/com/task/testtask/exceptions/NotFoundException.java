package com.task.testtask.exceptions;

public class NotFoundException extends AbstractCommonException {
    public static final Detail USER_ID_NOT_FOUND =
        new Detail(404, "user_id_not_found", "User with this ID doesn't exist");

    public NotFoundException(Detail detail) {
        super(detail);
    }
}
