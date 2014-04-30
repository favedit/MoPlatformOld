package com.zqinet.logic.data.game;

import org.mo.com.lang.*;
import org.mo.com.collections.*;
import org.mo.com.data.*;
import org.mo.data.logic.*;

//============================================================
// <T>角色物品信息逻辑。</T>
//============================================================
public class FGameRoleSkillLogic extends FLogicDataset
{
   // 的定义。
   public final static FLogicTable Table = new FLogicTable("GM_ROLE_SKILL");

   // 字段对象标识的定义。
   public final static FLogicField FieldOuid = new FLogicField("OUID");

   // 字段有效性的定义。
   public final static FLogicField FieldOvld = new FLogicField("OVLD");

   // 字段唯一标识的定义。
   public final static FLogicField FieldUniqueId = new FLogicField("UNIQUE_ID");

   // 字段角色编号的定义。
   public final static FLogicField FieldRoleId = new FLogicField("ROLE_ID");

   // 字段技能模板编号的定义。
   public final static FLogicField FieldSkillTid = new FLogicField("SKILL_TID");

   // 字段级别的定义。
   public final static FLogicField FieldLevel = new FLogicField("LEVEL");

   // 字段技能归属的定义。
   public final static FLogicField FieldBelongCd = new FLogicField("BELONG_CD");

   // 字段归属编号的定义。
   public final static FLogicField FieldBelongId = new FLogicField("BELONG_ID");

   // 字段標誌的定义。
   public final static FLogicField FieldFlags = new FLogicField("FLAGS");

   // 字段物品包类型的定义。
   public final static FLogicField FieldItemBagCd = new FLogicField("ITEM_BAG_CD");

   // 字段物品背包编号的定义。
   public final static FLogicField FieldItemBagId = new FLogicField("ITEM_BAG_ID");

   // 字段物品包索引的定义。
   public final static FLogicField FieldItemBagIndex = new FLogicField("ITEM_BAG_INDEX");

   // 字段物品快捷栏编号的定义。
   public final static FLogicField FieldItemBagShortcutId = new FLogicField("ITEM_BAG_SHORTCUT_ID");

   // 字段物品快捷栏索引的定义。
   public final static FLogicField FieldItemBagShortcutIndex = new FLogicField("ITEM_BAG_SHORTCUT_INDEX");

   // 字段创建用户标识的定义。
   public final static FLogicField FieldCreateUserId = new FLogicField("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static FLogicField FieldCreateDate = new FLogicField("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static FLogicField FieldUpdateUserId = new FLogicField("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static FLogicField FieldUpdateDate = new FLogicField("UPDATE_DATE");

   //============================================================
   // <T>构造角色物品信息逻辑单元。</T>
   //============================================================
   public FGameRoleSkillLogic(){
   }

   //============================================================
   // <T>构造角色物品信息逻辑单元。</T>
   //
   // @param connection 链接
   //============================================================
   public FGameRoleSkillLogic(ISqlConnection connection){
      _connection = connection;
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 数据单元
   //============================================================
   public FGameRoleSkillUnit find(long recordId){
      // 检查记录编号
      if(0 == recordId){
         return null;
      }
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      if(null == row){
         return null;
      }
      // 获得数据
      FGameRoleSkillUnit unit = new FGameRoleSkillUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public FGameRoleSkillUnit serach(String whereSql){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE ");
      sql.append(whereSql);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      // 获得数据
      if(null == row){
         return null;
      }
      FGameRoleSkillUnit unit = new FGameRoleSkillUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @return 数据单元集合
   //============================================================
   public FGameRoleSkillUnit[] fetch(String whereSql){
      return fetch(whereSql, null, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @return 数据单元集合
   //============================================================
   public FGameRoleSkillUnit[] fetch(String whereSql, String orderSql){
      return fetch(whereSql, orderSql, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param limitCount 限制条数
   // @return 数据单元集合
   //============================================================
   public FGameRoleSkillUnit[] fetch(String whereSql, String orderSql, int limitCount){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      if(!RString.isEmpty(whereSql)){
         sql.append(" WHERE ");
         sql.append(whereSql);
      }
      if(!RString.isEmpty(orderSql)){
         sql.append(" ORDER BY ");
         sql.append(orderSql);
      }
      if(limitCount > 0){
         sql.append(" LIMIT ");
         sql.append(limitCount);
      }
      // 执行命令
      FDataset dataset = _connection.fetchDataset(sql.toString());
      int count = dataset.count();
      // 获得数据
      FGameRoleSkillUnit[] units = new FGameRoleSkillUnit[count];
      for(int n = 0; n < count; n++){
         FGameRoleSkillUnit unit = new FGameRoleSkillUnit();
         unit.load(dataset.get(n));
         units[n] = unit;
      }
      return units;
   }

   //============================================================
   // <T>根据条件获得全部数据单元集合。</T>
   //
   // @return 数据单元集合
   //============================================================
   public FGameRoleSkillUnit[] fetchAll(){
      return fetch(null);
   }

   //============================================================
   // <T>插入一个数据单元。</T>
   //
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   public boolean doInsert(FGameRoleSkillUnit unit){
      // 生成命令
      FSql sql = new FSql("INSERT INTO ");
      sql.append(Table.name());
      sql.append("(");
      sql.append("`OVLD`");
      sql.append(",`UNIQUE_ID`");
      sql.append(",`ROLE_ID`");
      sql.append(",`SKILL_TID`");
      sql.append(",`LEVEL`");
      sql.append(",`BELONG_CD`");
      sql.append(",`BELONG_ID`");
      sql.append(",`FLAGS`");
      sql.append(",`ITEM_BAG_CD`");
      sql.append(",`ITEM_BAG_ID`");
      sql.append(",`ITEM_BAG_INDEX`");
      sql.append(",`ITEM_BAG_SHORTCUT_ID`");
      sql.append(",`ITEM_BAG_SHORTCUT_INDEX`");
      sql.append(",`CREATE_USER_ID`");
      sql.append(",`CREATE_DATE`");
      sql.append(",`UPDATE_USER_ID`");
      sql.append(",`UPDATE_DATE`");
      sql.append(") VALUES(");
      sql.append(unit.ovld());
      sql.append(',');
      sql.append(unit.uniqueId());
      sql.append(',');
      sql.append(unit.roleId());
      sql.append(',');
      sql.append(unit.skillTid());
      sql.append(',');
      sql.append(unit.level());
      sql.append(',');
      sql.append(unit.belongCd());
      sql.append(',');
      sql.append(unit.belongId());
      sql.append(',');
      sql.append(unit.flags());
      sql.append(',');
      sql.append(unit.itemBagCd());
      sql.append(',');
      sql.append(unit.itemBagId());
      sql.append(',');
      sql.append(unit.itemBagIndex());
      sql.append(',');
      sql.append(unit.itemBagShortcutId());
      sql.append(',');
      sql.append(unit.itemBagShortcutIndex());
      sql.append(",0,NOW(),0,NOW())");
      // 执行命令
      long recordId = _connection.executeInsertSql(sql.toString());
      unit.setOuid(recordId);
      return true;
   }

   //============================================================
   // <T>更新一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doUpdate(FGameRoleSkillUnit unit, long recordId){
      // 检查记录编号
      if(0 == recordId){
         throw new FFatalError("Record id is empty. (record_id={1})", recordId);
      }
      // 生成命令
      FSql sql = new FSql("UPDATE ");
      sql.append(Table.name());
      sql.append(" SET OVLD=");
      sql.append(unit.ovld());
      if(unit.isUniqueIdChanged()){
         sql.append(",`UNIQUE_ID`=");
         sql.append(unit.uniqueId());
      }
      if(unit.isRoleIdChanged()){
         sql.append(",`ROLE_ID`=");
         sql.append(unit.roleId());
      }
      if(unit.isSkillTidChanged()){
         sql.append(",`SKILL_TID`=");
         sql.append(unit.skillTid());
      }
      if(unit.isLevelChanged()){
         sql.append(",`LEVEL`=");
         sql.append(unit.level());
      }
      if(unit.isBelongCdChanged()){
         sql.append(",`BELONG_CD`=");
         sql.append(unit.belongCd());
      }
      if(unit.isBelongIdChanged()){
         sql.append(",`BELONG_ID`=");
         sql.append(unit.belongId());
      }
      if(unit.isFlagsChanged()){
         sql.append(",`FLAGS`=");
         sql.append(unit.flags());
      }
      if(unit.isItemBagCdChanged()){
         sql.append(",`ITEM_BAG_CD`=");
         sql.append(unit.itemBagCd());
      }
      if(unit.isItemBagIdChanged()){
         sql.append(",`ITEM_BAG_ID`=");
         sql.append(unit.itemBagId());
      }
      if(unit.isItemBagIndexChanged()){
         sql.append(",`ITEM_BAG_INDEX`=");
         sql.append(unit.itemBagIndex());
      }
      if(unit.isItemBagShortcutIdChanged()){
         sql.append(",`ITEM_BAG_SHORTCUT_ID`=");
         sql.append(unit.itemBagShortcutId());
      }
      if(unit.isItemBagShortcutIndexChanged()){
         sql.append(",`ITEM_BAG_SHORTCUT_INDEX`=");
         sql.append(unit.itemBagShortcutIndex());
      }
      if(unit.isCreateUserIdChanged()){
         sql.append(",`CREATE_USER_ID`=");
         sql.append(unit.createUserId());
      }
      sql.append(",UPDATE_USER_ID=0,UPDATE_DATE=NOW()");
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doDelete(long recordId){
      // 生成命令
      FSql sql = new FSql("DELETE FROM ");
      sql.append(Table.name());
      sql.append("WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }
}