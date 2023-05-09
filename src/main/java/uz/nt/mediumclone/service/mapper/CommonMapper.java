package uz.nt.mediumclone.service.mapper;

import org.springframework.stereotype.Component;

public interface CommonMapper<D,E> {

    D toDto(E e);
    E toEntity(D d);
}
