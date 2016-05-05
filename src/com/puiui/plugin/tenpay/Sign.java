package com.puiui.plugin.tenpay;

import java.util.SortedMap;

/**
 * Created by zhaiyinghao on 16/5/5.
 */
public interface Sign {

    String sign(SortedMap<String, String> signMap);

}
