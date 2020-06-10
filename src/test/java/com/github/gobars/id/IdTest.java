package com.github.gobars.id;

import com.github.gobars.id.db.DbId;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IdTest {
  @Test
  public void next() {
    assertTrue(Id.next() > 0);
  }

  @Test
  public void dbid() {
    assertTrue(DbId.next() > 0);
  }
}
