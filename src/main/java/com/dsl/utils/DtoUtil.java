package com.dsl.utils;

import java.util.List;
import com.dsl.models.dtos.UnitTestRequest;

public class DtoUtil {

    public static boolean validRequests(List<UnitTestRequest> unitTestRequests) {
    	if(unitTestRequests != null && unitTestRequests.size() > 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
