#### 解法一
注意题目给出的条件，是 **二叉搜索树**，这就是意味着节点之间是有顺序关系的。   
如果我们把整棵树都 **遍历** 一遍，将遍历的结果保存下来，比如放到一个数组中。   
那么这个数组应该是有序的。   
   
既然是有序的那就好办了，我们将这个有序的数组遍历一遍。   
如果数组是完全有序的，那么直接返回就可以了。   
否则，我们找到顺序不一致的两个下标```i```和```j```，将```arr[i].val```和```arr[j].val```的值互换一下即可。   

![1.jpg](https://pic.leetcode-cn.com/ceaf09da74f78f235f329dbc588f63da7464590947edb8c0415a4bd9ff493299-1.jpg)


代码实现:
```Java []
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root,list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for(int i=0;i<list.size()-1;++i) {
            if(list.get(i).val>list.get(i+1).val) {
                y = list.get(i+1);
                if(x==null) {
                    x = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历二叉树，并将遍历的结果保存到list中        
    private void dfs(TreeNode node,List<TreeNode> list) {
        if(node==null) {
            return;
        }
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }
}
```
```Python []
class Solution(object):
    def recoverTree(self, root):
        nodes = []
        # 中序遍历二叉树，并将遍历的结果保存到list中        
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            nodes.append(root)
            dfs(root.right)
        dfs(root)
        x = None
        y = None
        pre = nodes[0]
        # 扫面遍历的结果，找出可能存在错误交换的节点x和y
        for i in xrange(1,len(nodes)):
            if pre.val>nodes[i].val:
                y=nodes[i]
                if not x:
                    x = pre
            pre = nodes[i]
        # 如果x和y不为空，则交换这两个节点值，恢复二叉搜索树 
        if x and y:
            x.val,y.val = y.val,x.val
```



#### 解法二
解法一种，我们利用了额外的数组保存了遍历的结果，如果后面一个数比前面一个数小，那就找到了要交换的节点。  

![2.jpg](https://pic.leetcode-cn.com/6c7808ca105f2835abfdbfd5d31c9214bf76fcda58ced013db6d81b3e9aac356-2.jpg)

按照同样的思路，用中序遍历的方式遍历这颗二叉搜索树，我们再增加一个辅助的```pre```指针，记录 **上一个** 节点的值。   
如果 **当前节点的值**，小于 **上一个节点的值**，这就找到了需要交换的节点。利用这种方式，就不需要额外的数组空间了。   
详细过程请点击查看下面的幻灯片:   
      
 ![幻灯片4.JPG](https://pic.leetcode-cn.com/2fa3f3d20a3f244930ad4e1c88359f3874d09b9a9400ea616e89661e5d4aa2b3-%E5%B9%BB%E7%81%AF%E7%89%874.JPG) ![幻灯片5.JPG](https://pic.leetcode-cn.com/b49381418b6bc03019c901f1805c47654b49c1fff291e4199f2ba1cb5b5e7e64-%E5%B9%BB%E7%81%AF%E7%89%875.JPG) ![幻灯片6.JPG](https://pic.leetcode-cn.com/bdd689722222f89a451f8a720bc1e09eb96a08e2f76dfa8b616431c7744af6e9-%E5%B9%BB%E7%81%AF%E7%89%876.JPG) ![幻灯片7.JPG](https://pic.leetcode-cn.com/714c655a43c2194123079c875eb109becdf2e7cc19e64af8eaa6fb666799f781-%E5%B9%BB%E7%81%AF%E7%89%877.JPG) ![幻灯片8.JPG](https://pic.leetcode-cn.com/8a68963aaabe9ebfb2d01fbe345b71775e920063872c7189d1574725cb259aac-%E5%B9%BB%E7%81%AF%E7%89%878.JPG) ![幻灯片9.JPG](https://pic.leetcode-cn.com/f0204181b910e55a1f18cbc16b177d33bac1bec942c05790c36715c0ca83ecf1-%E5%B9%BB%E7%81%AF%E7%89%879.JPG) ![幻灯片10.JPG](https://pic.leetcode-cn.com/10a8018e1c122b326e580dd164d72b3c4ff659f9ff59f72b12fc8d3240bcd16e-%E5%B9%BB%E7%81%AF%E7%89%8710.JPG) ![幻灯片11.JPG](https://pic.leetcode-cn.com/4c96c5e1bdcf3044a4638d3c2e11a38e3d140900158dafefbddb0c671b132e47-%E5%B9%BB%E7%81%AF%E7%89%8711.JPG) ![幻灯片12.JPG](https://pic.leetcode-cn.com/5ef3eb1d00e8f3afee499016d0d59d126878d600de5b13dd4a1db0463897baf9-%E5%B9%BB%E7%81%AF%E7%89%8712.JPG) ![幻灯片13.JPG](https://pic.leetcode-cn.com/9d110a0cd8b298e7dcf6afa7c3c73da9fd128832d809025b6817a2f9621d0605-%E5%B9%BB%E7%81%AF%E7%89%8713.JPG) ![幻灯片14.JPG](https://pic.leetcode-cn.com/5696902c2681476a18e7ff1a5af11496f855d2f7ce469cd1c66ee5e049c955d9-%E5%B9%BB%E7%81%AF%E7%89%8714.JPG) ![幻灯片15.JPG](https://pic.leetcode-cn.com/b997d85df1cd39cea52f0425c6dc78dc939a71f06971b07fc34c508c177fbedc-%E5%B9%BB%E7%81%AF%E7%89%8715.JPG) ![幻灯片16.JPG](https://pic.leetcode-cn.com/17f6481be6702dd2a87a1333756ce4b49b8ceca9cfea69858fa373ded4acbb2f-%E5%B9%BB%E7%81%AF%E7%89%8716.JPG) ![幻灯片17.JPG](https://pic.leetcode-cn.com/f04f38292849ccb26ae6deab09da9ce3d02e046403746193174cfb48f3fe3c04-%E5%B9%BB%E7%81%AF%E7%89%8717.JPG) ![幻灯片18.JPG](https://pic.leetcode-cn.com/463f29ddf32fbb9ceab88be960348fab21c58eed478b6610f7241ffdb1fed442-%E5%B9%BB%E7%81%AF%E7%89%8718.JPG) ![幻灯片19.JPG](https://pic.leetcode-cn.com/1b55bcdade25130adcbdf428634361c2fc4172ea8c7070609dca400a0e68b4e9-%E5%B9%BB%E7%81%AF%E7%89%8719.JPG) ![幻灯片20.JPG](https://pic.leetcode-cn.com/ac6da7bac18f78d80cfadf8ddfb1a1c38dd476df917b0de3042924d474045936-%E5%B9%BB%E7%81%AF%E7%89%8720.JPG) 



注意，这种方式仍然使用了外部空间，虽然我们只用了常数个变量，但是递归调用仍然是需要额外空间的，其空间复杂度是 *O(h)*，`h` 为树的高度。   
所以用递归的方式遍历，或者手动模拟栈的方式遍历，都没有达到真正的常数空间。   

代码实现 :
```Java []
class Solution {
    //用两个变量x，y来记录需要交换的节点
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        //如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
	
    //中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
    private void dfs(TreeNode node) {
        if(node==null) {
            return;
        }
        dfs(node.left);
        if(pre==null) {
            pre = node;
        }
        else {
            if(pre.val>node.val) {
                y = node;
                if(x==null) {
                    x = pre;
                }
            }
            pre = node;
        }
        dfs(node.right);
    }
}
```
```Python []
class Solution(object):
    def recoverTree(self, root):
        # 用两个变量x，y来记录需要交换的节点
        self.x = None
        self.y = None
        self.pre = None
        # 中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            if not self.pre:
                self.pre = root
            else:
                if self.pre.val>root.val:
                    self.y = root
                    if not self.x:
                        self.x = self.pre
                self.pre = root
            dfs(root.right)
        dfs(root)
        # 如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
        if self.x and self.y:
            self.x.val,self.y.val = self.y.val,self.x.val
```



#### 解法三
解法二还不是真正的常数空间复杂度，想要达到常数空间，我们可以用 **莫里斯遍历**，这种方式可以做到 *O(1)* 的空间复杂度去遍历一棵树。   
我们先看看莫里斯遍历到底是咋回事

![4.jpg](https://pic.leetcode-cn.com/fde85797d0aa3cee9f8a84f39e820aed269f6c45b8eaf4d0672489c08f98090b-4.jpg)

回想一下中序遍历的递归版本是
```
dfs(root.left)
打印节点 root
dfs(root.right)
```
也就是一路往左走到底，左边走不通了，再往右边走。对于上图来说，就是```4```->```3```->```1```这个过程，一路往左，走不通了再往右，也就是遍历```2```。   
当然如果```2```的右边还有节点那么还会继续遍历下去。   
现在```2```的右边已经是空了，对于递归来说操作系统自动出栈，然后会访问```3```这个节点。    
既然```2```是叶子节点，左右子树都是空，我们可以利用这个空闲出来的信息，将```2```的右子树指向```3```，这样当```2```遍历完后，再往右走，就会自动走到```3```这个节点了。   
同理，将```3```的右子树指向```4```，将```6```的右子树指向```7```。   
这样的话，我们就可以省去额外的栈空间了。利用叶子节点的右子树这个特点，将其重新赋予指向关系 ，就是莫里斯遍历的核心了。   
   
不过光是这样还不行，再回看上面那张图，其实已经不是一棵树了，而是变成图了。因为出现了循环。  
所以，我们还需要将新加这个指向关系给去掉。 

![5.jpg](https://pic.leetcode-cn.com/ae90c217115c66f1443f2a0d652450a4992caa09c1374008196f4c542ca43767-5.jpg)

对于上图来说，假设我们已经遍历到```4``` 这个节点了，那就意味着```4```在左子树都遍历完了，对应的就是```1```，```2```，```3```都遍历完了。   
```3.right=4```这个是我们新加上的，既然现在已经遍历到```4```了，我们就可以将```3.right=null```，将这个指向关系还原即可。   
从上图中也可以看出，所谓新加的指向关系，就是找到根节点左子树的最右子树，然后将最右子树的```right```指向根节点。

完整执行过程请点击下面幻灯片查看:
   
 ![幻灯片25.JPG](https://pic.leetcode-cn.com/c2f685a714f2d5c7848367ef1d71bec2a3d764c5faec3c8ce20def113a300705-%E5%B9%BB%E7%81%AF%E7%89%8725.JPG) ![幻灯片26.JPG](https://pic.leetcode-cn.com/c7237f2d122947b8c892cfd1d6046a9eeed13857e62aaf7012b9597696ee5068-%E5%B9%BB%E7%81%AF%E7%89%8726.JPG) ![幻灯片27.JPG](https://pic.leetcode-cn.com/15276db6b24ce4c885989140ebf0a5f422aa387f72a658380a9396fa0aa90102-%E5%B9%BB%E7%81%AF%E7%89%8727.JPG) ![幻灯片28.JPG](https://pic.leetcode-cn.com/95a33686b3c589549a3530d5706cb97e8d70fcaccd2caa6b38b9c05bc4fbb6d5-%E5%B9%BB%E7%81%AF%E7%89%8728.JPG) ![幻灯片29.JPG](https://pic.leetcode-cn.com/5d49b4378dc4d11393829b0f484657fe3551fd1873baecb1e0f3d509e638f500-%E5%B9%BB%E7%81%AF%E7%89%8729.JPG) ![幻灯片30.JPG](https://pic.leetcode-cn.com/ddff804269ba06dc28499934c3ccf981882e72e847f00ec859159035b0fd3654-%E5%B9%BB%E7%81%AF%E7%89%8730.JPG) ![幻灯片31.JPG](https://pic.leetcode-cn.com/29ece425432859a57efb40b2d837b35513a53aac7911705b7c1d0ffa81cab7e7-%E5%B9%BB%E7%81%AF%E7%89%8731.JPG) ![幻灯片32.JPG](https://pic.leetcode-cn.com/4e5cbe1fea3aeccca3125f1d52f2754acf03e0575233802c0f00c2d5e97c7837-%E5%B9%BB%E7%81%AF%E7%89%8732.JPG) ![幻灯片33.JPG](https://pic.leetcode-cn.com/01b27cc41231e74504e7b6a338294301fd6127c548dd1d5dcd5628a388faf926-%E5%B9%BB%E7%81%AF%E7%89%8733.JPG) ![幻灯片34.JPG](https://pic.leetcode-cn.com/0aecbaae2ab759286925599c2a86c1a8ec7ebbdfa651dcc3607ec35bb2642cd8-%E5%B9%BB%E7%81%AF%E7%89%8734.JPG) ![幻灯片35.JPG](https://pic.leetcode-cn.com/b117de7f1778c56b38ae5601b50a505e9da12876428c3aed4435b02e1a47e151-%E5%B9%BB%E7%81%AF%E7%89%8735.JPG) ![幻灯片36.JPG](https://pic.leetcode-cn.com/c66a9077e063dab352df84ab1fc473be676326e476cb255a22bfc3a15e2dcffd-%E5%B9%BB%E7%81%AF%E7%89%8736.JPG) ![幻灯片37.JPG](https://pic.leetcode-cn.com/091f023c404832766972261923ee45368cb5ca18d38045270727b2281b6613d0-%E5%B9%BB%E7%81%AF%E7%89%8737.JPG) ![幻灯片38.JPG](https://pic.leetcode-cn.com/d81f58fb2a6402973f183bed8a8f92bec4287e05ac5f8ec0c21b72a02cee14b4-%E5%B9%BB%E7%81%AF%E7%89%8738.JPG) ![幻灯片39.JPG](https://pic.leetcode-cn.com/d8f81ddf17efda251d65fa936c45846ef61e6991a0db520ca0134b2d6354fb25-%E5%B9%BB%E7%81%AF%E7%89%8739.JPG) ![幻灯片40.JPG](https://pic.leetcode-cn.com/89240b511fdfd99a9061c9752a7b12a42dee0901621769834eb9abbeed67d164-%E5%B9%BB%E7%81%AF%E7%89%8740.JPG) ![幻灯片41.JPG](https://pic.leetcode-cn.com/71c9b48445a6affd19970e4ad7741659194617191d641863882eb535abb2ad45-%E5%B9%BB%E7%81%AF%E7%89%8741.JPG) ![幻灯片42.JPG](https://pic.leetcode-cn.com/aa53bc05eddedd2a60b682a27504846c40c7964dcf7a6e104e7c27fead328623-%E5%B9%BB%E7%81%AF%E7%89%8742.JPG) ![幻灯片43.JPG](https://pic.leetcode-cn.com/9473206b500d28227f0582eee56b33de298cf045c72cd8b8cba17d98b0ad986e-%E5%B9%BB%E7%81%AF%E7%89%8743.JPG) ![幻灯片44.JPG](https://pic.leetcode-cn.com/7cde1c2ccae143e427b62fbff4b5d6d33487b716115b6251415ec725bf014dc5-%E5%B9%BB%E7%81%AF%E7%89%8744.JPG) ![幻灯片45.JPG](https://pic.leetcode-cn.com/5b596d5f0162e965617440d8aa40746a62623362c4ae1640bf34f2a0def3dcd5-%E5%B9%BB%E7%81%AF%E7%89%8745.JPG) ![幻灯片46.JPG](https://pic.leetcode-cn.com/48c1086fb72d256e46cf6ce7c4a5fe1a76f1776f6c1b8002e8b776acc76d6620-%E5%B9%BB%E7%81%AF%E7%89%8746.JPG) ![幻灯片47.JPG](https://pic.leetcode-cn.com/c312e350955468ea26e241a09f8ada2d6be544d5bb58b295994350f60d6747dd-%E5%B9%BB%E7%81%AF%E7%89%8747.JPG) ![幻灯片48.JPG](https://pic.leetcode-cn.com/463e687cf21b3272588b064db9710c37cb07a305941bb7a51f78366f81ee8379-%E5%B9%BB%E7%81%AF%E7%89%8748.JPG) ![幻灯片49.JPG](https://pic.leetcode-cn.com/a6aa0f0241e624867de4f3fbb269da388fc1d1dc100fe990afb17ae1c263304d-%E5%B9%BB%E7%81%AF%E7%89%8749.JPG) ![幻灯片50.JPG](https://pic.leetcode-cn.com/c3cb2c6f017b6f6985db9116d79e051e07728c6460ca068ab452573e8f2304c3-%E5%B9%BB%E7%81%AF%E7%89%8750.JPG) ![幻灯片51.JPG](https://pic.leetcode-cn.com/3bcd5cbf97917ff0b0ed1ce7a926792e8d106783b4b6d4a11d3b72f37a3d7677-%E5%B9%BB%E7%81%AF%E7%89%8751.JPG) 
   
   
仔细看上图，```3```->```1```->```2```，这几个节点会走两遍。  
第一遍的时候，```3```的左子树的最右节点是```2```，于是将```2.right```指向```3```。
之后等```1```，```2```两个节点都遍历完后，当前节点走到了```3```这里，又会触发一遍 根节点的左子树的最右节点这个循环查找逻辑，此时可以判断出最右的节点```2.right```是等于root的，所以就将2.right重新设置为空，即还原回去。
   
   
代码实现:
```Java []
class Solution {
	public void recoverTree(TreeNode root) {
		if(root==null) {
			return;
		}
		TreeNode x = null;
		TreeNode y = null;
		TreeNode pre = null;
		TreeNode tmp = null;
		while(root!=null) {
			if(root.left!=null) {
				tmp = root.left;
				while(tmp.right!=null && tmp.right!=root) {
					tmp = tmp.right;
				}
				if(tmp.right==null) {
					tmp.right = root;
					root = root.left;
				}
				else {
					if(pre!=null && pre.val>root.val) {
						y = root;
						if(x==null) {
							x = pre;
						}
					}
					pre = root;
					tmp.right = null;
					root = root.right;
				}
			}
			else {
				if(pre!=null && pre.val>root.val) {
					y = root;
					if(x==null) {
						x = pre;
					}
				}
				pre = root;
				root = root.right;
			}
		}
		if(x!=null && y!=null) {
			int t = x.val;
			x.val = y.val;
			y.val = t;
		}
	}
}
```
```Python []
class Solution(object):
    def recoverTree(self, root):
        x = None
        y = None
        pre = None
        tmp = None
        while root:
            if root.left:
                tmp = root.left
                while tmp.right and tmp.right!=root:
                    tmp = tmp.right
                if tmp.right is None:
                    tmp.right = root
                    root = root.left
                else:
                    if pre and pre.val>root.val:
                        y = root
                        if not x:
                            x = pre
                    pre = root
                    tmp.right = None
                    root = root.right
            else:
                if pre and pre.val>root.val:
                    y = root
                    if not x:
                        x = pre
                pre = root
                root = root.right
        if x and y:
            x.val,y.val = y.val,x.val
```





