package com.dfinite.sfgpetclinic.services;

import com.dfinite.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
