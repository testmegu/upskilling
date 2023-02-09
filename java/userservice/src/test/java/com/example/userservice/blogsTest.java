package com.example.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class blogsTest {
    @Test
    public void testSetId() {
        blogs blogs = new blogs();
        blogs.setId(1L);
        assertEquals(123L, blogs.getId().longValue());
    }

    @Test
    public void testSetProductname() {
        blogs blogs = new blogs();
        blogs.setProductname("Productname");
        assertEquals("Productname", blogs.getProductname());
    }

    @Test
    public void testSetHeadline() {
        blogs blogs = new blogs();
        blogs.setHeadline("Headline");
        assertEquals("Headline", blogs.getHeadline());
    }

    @Test
    public void testSetImg() {
        blogs blogs = new blogs();
        blogs.setImg("Img");
        assertEquals("Img", blogs.getImg());
    }

    @Test
    public void testSetDiscription() {
        blogs blogs = new blogs();
        blogs.setDiscription("Discription");
        assertEquals("Discription", blogs.getDiscription());
    }
}

