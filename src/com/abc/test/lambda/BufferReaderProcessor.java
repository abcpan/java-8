package com.abc.test.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/26 17:32
 */
@FunctionalInterface
public interface BufferReaderProcessor {
  void process(BufferedReader reader) throws IOException;
}
