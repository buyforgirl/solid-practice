package com.theladders.solid.dip.contentnode;

import com.theladders.solid.dip.contentnode.ContentNode;

public class RepositoryManager
{
  public ContentNode getNodeByUuid(String id)
  {
    ContentNode node = new ContentNode();

    node.addProperty("uuid", id);

    return node;
  }
}
