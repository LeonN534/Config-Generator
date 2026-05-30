import {
  DndContext,
  closestCenter,
  KeyboardSensor,
  PointerSensor,
  useSensor,
  useSensors,
  type DragEndEvent,
} from '@dnd-kit/core'
import {
  SortableContext,
  sortableKeyboardCoordinates,
  verticalListSortingStrategy,
} from '@dnd-kit/sortable'
import { useSortable } from '@dnd-kit/sortable'
import { CSS } from '@dnd-kit/utilities'
import { GripVertical, Plus, X } from 'lucide-react'
import { useI18n } from '@/i18n'
import ColorInput, { type ColorInputHandle } from '@/components/shared/ColorInput'

export interface NickItem {
  id: string
  value: string
}

interface Props {
  items: NickItem[]
  onUpdate: (id: string, value: string) => void
  onRemove: (id: string) => void
  onAdd: () => void
  onDragEnd: (event: DragEndEvent) => void
  nickRefs: React.MutableRefObject<Record<string, ColorInputHandle | null>>
  onNickFocus?: (id: string) => void
  onNickBlur?: () => void
}

function SortableItem({
  item,
  index,
  onUpdate,
  onRemove,
  canRemove,
  nickRef,
  onFocus,
  onBlur,
}: {
  item: NickItem
  index: number
  onUpdate: (id: string, value: string) => void
  onRemove: (id: string) => void
  canRemove: boolean
  nickRef: React.Ref<ColorInputHandle>
  onFocus?: () => void
  onBlur?: () => void
}) {
  const { attributes, listeners, setNodeRef, transform, transition, isDragging } = useSortable({
    id: item.id,
  })

  const style = {
    transform: CSS.Transform.toString(transform),
    transition,
    opacity: isDragging ? 0.4 : 1,
  }

  return (
    <div
      ref={setNodeRef}
      style={style}
      className="flex items-center gap-2 bg-white/[0.04] border border-white/[0.06] rounded-lg px-2 py-2
                 hover:border-white/[0.12] hover:bg-white/[0.06] transition-all group"
    >
      <button
        {...attributes}
        {...listeners}
        className="text-white/20 hover:text-[#f37b22]/60 cursor-grab active:cursor-grabbing transition-colors flex-shrink-0 px-1"
      >
        <GripVertical className="w-4 h-4" />
      </button>

      <ColorInput
        ref={nickRef}
        value={item.value}
        onChange={(v) => onUpdate(item.id, v)}
        inputId={item.id}
        onFocus={onFocus}
        onBlur={onBlur}
        placeholder={`Nick ${index + 1}`}
        className="flex-1 bg-transparent border-none"
      />

      {canRemove && (
        <button
          onClick={() => onRemove(item.id)}
          className="text-white/20 hover:text-red-400 transition-colors flex-shrink-0 px-1 opacity-0 group-hover:opacity-100 cursor-pointer"
        >
          <X className="w-4 h-4" />
        </button>
      )}
    </div>
  )
}

export default function DraggableNickList({ items, onUpdate, onRemove, onAdd, onDragEnd, nickRefs, onNickFocus, onNickBlur }: Props) {
  const { t } = useI18n()

  const sensors = useSensors(
    useSensor(PointerSensor, { activationConstraint: { distance: 5 } }),
    useSensor(KeyboardSensor, { coordinateGetter: sortableKeyboardCoordinates }),
  )

  return (
    <div className="space-y-2">
      <DndContext sensors={sensors} collisionDetection={closestCenter} onDragEnd={onDragEnd}>
        <SortableContext items={items.map((i) => i.id)} strategy={verticalListSortingStrategy}>
          {items.map((item, index) => (
            <SortableItem
              key={item.id}
              item={item}
              index={index}
              onUpdate={onUpdate}
              onRemove={onRemove}
              canRemove={items.length > 1}
              nickRef={(el) => { nickRefs.current[item.id] = el }}
              onFocus={() => onNickFocus?.(item.id)}
              onBlur={onNickBlur}
            />
          ))}
        </SortableContext>
      </DndContext>

      <button
        onClick={onAdd}
        className="flex items-center gap-1.5 text-xs text-white/30 hover:text-[#f37b22] transition-colors pt-1 cursor-pointer"
      >
        <Plus className="w-3.5 h-3.5" />
        {t('names.addNick')}
      </button>
    </div>
  )
}
