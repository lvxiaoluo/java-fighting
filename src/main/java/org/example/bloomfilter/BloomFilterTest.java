package org.example.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author lvle
 * @date 2022-04-06 19:41
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")),100000000,0.01);
        bloomFilter.put("test");
//        bloomFilter.put("fighting");
        System.out.println(bloomFilter.mightContain("fighting"));
    }
}
